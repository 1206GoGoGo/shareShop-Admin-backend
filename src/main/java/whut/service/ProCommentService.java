package whut.service;



import whut.pojo.ProductComment;
import whut.utils.ResponseData;



public interface ProCommentService {

	public ResponseData getListByProduct(String id,int pageindex, int pagesize);

	public ResponseData getListByUser(String id,int pageindex, int pagesize);
	
	public ResponseData add(ProductComment productComment);

	public ResponseData delete(String id);

	public ResponseData addAgain(String id, String content);

	public ResponseData getCommentById(String id);

	public ResponseData getListByCondition(String proName, String proCode, String userName,String star1,String star2,int pageindex, int pagesize);

}
