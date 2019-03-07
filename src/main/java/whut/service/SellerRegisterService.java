package whut.service;



import whut.pojo.SellerRegister;
import whut.utils.ResponseData;



public interface SellerRegisterService {

	
	public ResponseData getSellerList();

	public ResponseData add(SellerRegister sellerRegister);

	public ResponseData delete(String id);

	

	

}
