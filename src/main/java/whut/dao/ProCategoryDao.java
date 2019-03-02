package whut.dao;

import java.util.List;

import whut.pojo.ProductCategory;

public interface ProCategoryDao {

	public List<ProductCategory> getList();

	public void add(ProductCategory productCategory);

	public void modify(ProductCategory productCategory);

	public void delete(String id);

	public ProductCategory ifCategoryExist(String categoryCode);
	
	public ProductCategory ifHaveChild(String id);

}
