package whut.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

import whut.pojo.ProductInfo;

public interface ProInfoDao {

	List<ProductInfo> getList(Map<String, Object> map);

	ProductInfo getDetail(String id);

	void add(ProductInfo productInfo);

	//List<ProductInfo> search(@Param(value = "name") String name);
	List<ProductInfo> search(Map<String, Object> map);

	void modify(ProductInfo productInfo);

	void modifyAuditStatus(Map<String, String> map);

	void modifyShelfStatus(Map<String, String> map);

	List<ProductInfo> getListByCategory(Map<String, Object> map);

	ProductInfo getDetailByCode(String id);

	List<ProductInfo> getIfcheckedList(Map<String, Object> map);

	List<ProductInfo> getIfShelfList(Map<String, Object> map);

	List<ProductInfo> getListByCondition(Map<String, Object> map);

	
	

}
