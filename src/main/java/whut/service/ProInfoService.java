package whut.service;



import whut.pojo.ProductInfo;
import whut.utils.ResponseData;


public interface ProInfoService {

	public ResponseData getList();

	public ResponseData getDetail(String id);

	public ResponseData add(ProductInfo productInfo);

	public ResponseData search(String name);

	public ResponseData modify(ProductInfo productInfo);

	public ResponseData modifyAuditStatus(String id, String status);

	public ResponseData modifyShelfStatus(String id, String status);

	public ResponseData getListByCategory(String id);

	public ResponseData getDetailByCode(String id);

}
