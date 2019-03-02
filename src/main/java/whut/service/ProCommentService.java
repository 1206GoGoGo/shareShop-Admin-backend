package whut.service;

import java.util.List;

import whut.pojo.ProductComment;



public interface ProCommentService {

	public List<ProductComment> getListByProduct(String id);

	public List<ProductComment> getListByUser(String id);
	
	public void add(ProductComment productComment);

	public void delete(String id);

	public void addAgain(String id, String content);

	public ProductComment getCommentById(String id);

}
