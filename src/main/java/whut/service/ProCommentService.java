package whut.service;



import whut.pojo.ProductComment;
import whut.utils.ResponseData;



public interface ProCommentService {

	public ResponseData getListByProduct(String id);

	public ResponseData getListByUser(String id);
	
	public ResponseData add(ProductComment productComment);

	public ResponseData delete(String id);

	public ResponseData addAgain(String id, String content);

	public ProductComment getCommentById(String id);

}
