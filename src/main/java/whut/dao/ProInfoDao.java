package whut.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import whut.pojo.ProductInfo;

public interface ProInfoDao {

	List<ProductInfo> getList();

	ProductInfo getDetail(String id);

	void add(ProductInfo productInfo);

	List<ProductInfo> search(@Param(value = "name") String name);

	void modify(ProductInfo productInfo);

	void modifyAuditStatus(Map<String, String> map);

	void modifyShelfStatus(Map<String, String> map);

	List<ProductInfo> getListByCategory(String id);

	ProductInfo getDetailByCode(String id);

	List<ProductInfo> getIfcheckedList(String status);

	List<ProductInfo> getIfShelfList(String status);

	List<ProductInfo> getListByCondition(Map<String, String> map);

	
	

}
