package whut.dao;

import java.util.List;

import whut.pojo.SellerRegister;


public interface SellerRegisterDao {	

	public List<SellerRegister> getSellerList();

	public void add(SellerRegister sellerRegister);

	public void delete(String id);

}
