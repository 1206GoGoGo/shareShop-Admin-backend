package whut.service;

import java.util.List;

import whut.pojo.ProductDiscount;



public interface ProDiscountService {

	public List<ProductDiscount> getList();

	public ProductDiscount search(String id);

	public void add(ProductDiscount productDiscount);

	public void modify(ProductDiscount productDiscount);

}
