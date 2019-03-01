package whut.service;

import java.util.List;


import whut.pojo.ProductInfo;


public interface ProInfoService {

	public List<ProductInfo> getList();

	public ProductInfo getDetail(String id);

	public void add(ProductInfo productInfo);

	public List<ProductInfo> search(String name);

	public void modify(ProductInfo productInfo);

	public void modifyAuditStatus(String id, String status);

	public void modifyShelfStatus(String id, String status);

	ProductInfo ifProExist(String id);

}
