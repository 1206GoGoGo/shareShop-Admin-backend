package whut.service;

import java.util.List;

import whut.pojo.SellerRegister;
import whut.pojo.UserInfo;



public interface SellerInfoService {

	public List<UserInfo> getList();

	public UserInfo getDetail(String id);

	public void modify(UserInfo userInfo);

	public void add(SellerRegister sellerRegister);

	public void delete(String id);

	

	

}
