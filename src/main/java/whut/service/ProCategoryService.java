package whut.service;

import java.util.List;

import whut.pojo.ProductCategory;


public interface ProCategoryService {

	public List<ProductCategory> getList();

	public void add(ProductCategory productCategory);
	
	public void modify(ProductCategory productCategory);

	public void delete(String id);

	public ProductCategory ifCategoryExist(String categoryCode);

	public List<ProductCategory> ifHaveChild(String id);

	public void deleteConfirm(String id);

	

}
