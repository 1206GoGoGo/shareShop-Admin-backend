package whut.service.impl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProInfoDao;
import whut.pojo.ProductInfo;
import whut.pojo.ProductInfoForSearch;
import whut.service.ProInfoService;
import whut.utils.ResponseData;
import whut.utils.SolrJUtil;



@Service
public class ProInfoServiceImpl implements ProInfoService{

	@Autowired
	private ProInfoDao proInfoDao;
	
	private HttpSolrClient solrClient = SolrJUtil.getSolrClient();
	private String coreName = SolrJUtil.getCoreName();//创建的内核名
	
	@Override
	public ResponseData updateSolrData() {
		try{
			this.updateData();
			return new ResponseData(200,"success",null);
		}catch(Exception e) {
			System.out.println(e);
			return new ResponseData(400,"error",null);
		}
	}
	
	private void updateData() {
		List<ProductInfoForSearch> productInfoForSearchs = new ArrayList<ProductInfoForSearch>();
		productInfoForSearchs = proInfoDao.getSolrDoucumentList();
		//productInfoForSearchs.add(new ProductInfoForSearch(1, "Fashion hat", "", 1,1, 1, "", "", 1,1, 1, 21, null, "",1, null, null,12, 12.0, 11.0,11.0, 11, 11, 0));
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
	
	private void deleteData() {
		try {
			solrClient.deleteByQuery(coreName,"*:*");
			solrClient.commit(coreName);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResponseData getList(Integer pageindex, Integer pagesize) {
		// TODO Auto-generated method stub
		if(pageindex == null)
			pageindex = 0;
		if(pagesize == null)
			pagesize = 20;
		Map<String,Object> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<ProductInfo> list = proInfoDao.getList(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getDetail(String id) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = proInfoDao.getDetail(id);
		if(productInfo != null) {
			return new ResponseData(200,"success",productInfo);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	
	@Override
	public ResponseData add(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		if(productInfo.getProductName() != null) {
			proInfoDao.add(productInfo);
			return new ResponseData(200,"Successfully added",null);
		}else {
			return new ResponseData(500,"Add failed",null);
		}
	}

	@Override
	public ResponseData search(String name,Integer pageindex, Integer pagesize) {
		// TODO Auto-generated method stub
		if(pageindex == null)
			pageindex = 0;
		if(pagesize == null)
			pagesize = 20;
		Map<String,Object> map = new HashMap<>();
		map.put("productName", name);
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<ProductInfo> list = new ArrayList<>();
		list = proInfoDao.search(map);
		if(list.isEmpty())
			return new ResponseData(400,"No match was found",null);
		return new ResponseData(200,"success",list);
	}

	@Override
	public ResponseData modify(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		proInfoDao.modify(productInfo);
		return new ResponseData(200,"modify success",null);
	}


	@Override
	public ResponseData modifyAuditStatus(String id, String status) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("productId", id);
		map.put("auditStatus", status);
		proInfoDao.modifyAuditStatus(map);
		return new ResponseData(200,"modifyAuditStatus success",null);
	}

	@Override
	public ResponseData modifyShelfStatus(String id, String status) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("productId", id);
		map.put("publishStatus", status);
		proInfoDao.modifyShelfStatus(map);
		return new ResponseData(200,"modifyShelfStatus success",null);
	}

	@Override
	public ResponseData getListByCategory(String id,Integer pageindex, Integer pagesize) {
		// TODO Auto-generated method stub
		if(pageindex == null)
			pageindex = 0;
		if(pagesize == null)
			pagesize = 20;
		Map<String,Object> map = new HashMap<>();
		map.put("oneCategoryId", id);
		map.put("twoCategoryId", id);
		map.put("threeCategoryId", id);
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<ProductInfo> list = new ArrayList<>();
		list = proInfoDao.getListByCategory(map);
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}

	@Override
	public ResponseData getDetailByCode(String id) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = proInfoDao.getDetailByCode(id);
		if(productInfo != null) {
			return new ResponseData(200,"success",productInfo);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getIfcheckedList(String status,Integer pageindex, Integer pagesize) {
		// TODO Auto-generated method stub
		if(pageindex == null)
			pageindex = 0;
		if(pagesize == null)
			pagesize = 20;
		Map<String,Object> map = new HashMap<>();
		map.put("auditStatus", status);
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<ProductInfo> list = proInfoDao.getIfcheckedList(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getIfShelfList(String status,Integer pageindex, Integer pagesize) {
		// TODO Auto-generated method stub
		if(pageindex == null)
			pageindex = 0;
		if(pagesize == null)
			pagesize = 20;
		Map<String,Object> map = new HashMap<>();
		map.put("publishStatus", status);
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<ProductInfo> list = proInfoDao.getIfShelfList(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getListByCondition(String name, String procode, String categoryId1, String categoryId2,
			String categoryId3, String status1, String status2,Integer pageindex, Integer pagesize) {
		// TODO Auto-generated method stub
		if(pageindex == null)
			pageindex = 0;
		if(pagesize == null)
			pagesize = 20;
		Map<String, Object> map = new HashMap<>();
		map.put("productName", name);
		map.put("productCode", procode);
		map.put("oneCategoryId", categoryId1);
		map.put("twoCategoryId", categoryId2);
		map.put("threeCategoryId", categoryId3);
		map.put("publishStatus", status1);
		map.put("auditStatus", status2);
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<ProductInfo> list = proInfoDao.getListByCondition(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}	
	
}
