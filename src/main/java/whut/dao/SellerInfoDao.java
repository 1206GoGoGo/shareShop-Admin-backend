package whut.dao;

import java.util.List;

import whut.pojo.UserInfo;

public interface SellerInfoDao {

	List<UserInfo> getSellerList();

	UserInfo getUserInfo(String id);

	void addSeller(String id);

	void deleteSeller(String id);

	

}
