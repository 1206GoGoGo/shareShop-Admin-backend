package whut.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;

import whut.dao.ProInfoDao;
import whut.pojo.ProductInfo;
import whut.pojo.ProductInfoForSearch;

/**
 * 搜索服务器工具类
 * @author chen cheng
 *
 */

public class SolrJUtil {
	
	@Autowired
	private static ProInfoDao proInfoDao;
	private static HttpSolrClient solrClient;
	private static String coreName =  "products_core";//创建的内核名
	static {
		String serverUrl = "http://localhost:8888/solr";
		solrClient = new HttpSolrClient.Builder(serverUrl).withConnectionTimeout(10000).withSocketTimeout(60000).build();
	}
	
	
	public static String search(int page, int rows, String searchWord, String highlightField, String[] queryItem) {
        //创建查询对象
        SolrQuery solrQuery = new SolrQuery();
        //设置查询条件
        solrQuery.setQuery(searchWord);
        //设置分页
        solrQuery.setStart((page - 1) * rows);
        solrQuery.setRows(rows);
        //设置默认搜素域
        solrQuery.set("df", "Ptitle");
        solrQuery.setSort("id", SolrQuery.ORDER.asc);
        //solrQuery.addSort("id", SolrQuery.ORDER.desc);
        
        //设置高亮显示
        if(!(highlightField == null)) {
            solrQuery.setHighlight(true);
            solrQuery.addHighlightField(highlightField);
            solrQuery.setHighlightSimplePre("<em style=\"color:red\">");
            solrQuery.setHighlightSimplePost("</em>");
        }

        solrQuery.setFields(queryItem);
        

        //根据查询条件查询索引库
        QueryResponse queryResponse = null;
		try {
			queryResponse = solrClient.query(coreName,solrQuery);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        //取查询结果
        SolrDocumentList solrDocumentList = queryResponse.getResults();
        SolrDocumentListForReturn solrDocumentListForReturn = new SolrDocumentListForReturn(solrDocumentList);
        System.out.println(solrDocumentListForReturn);
        return solrDocumentListForReturn.toString();
	}
	
	public static void updateData() {
		List<ProductInfoForSearch> productInfoForSearchs = new ArrayList<ProductInfoForSearch>();
		productInfoForSearchs = proInfoDao.getSolrDoucumentList();
		if(!productInfoForSearchs.isEmpty()) {
			deleteData();
		}else {
			return;
		}
		try {
			solrClient.addBeans(coreName,productInfoForSearchs);
			solrClient.commit(coreName);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteData() {
		try {
			solrClient.deleteByQuery(coreName,"*:*");
			solrClient.commit(coreName);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
