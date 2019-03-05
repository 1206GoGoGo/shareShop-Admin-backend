package whut.service;

import java.util.List;

import whut.pojo.SellerRegister;



public interface SellerRegisterService {

	
	public List<SellerRegister> getSellerList();

	public void add(SellerRegister sellerRegister);

	public void delete(String id);

	

	

}
