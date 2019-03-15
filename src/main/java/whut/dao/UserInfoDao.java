package whut.dao;

import java.util.List;
import java.util.Map;

import whut.pojo.UserInfo;

public interface UserInfoDao {

	//String status,String pageindex, String pagesize
	//获取完整用户信息--不包括seller
	List<UserInfo> getList(Map<String, String> map);
	
	List<UserInfo> getSellerList();

	void add(UserInfo user);

	//修改用户状态
	void delete(int id);

	//修改用户信息表
	void modify(UserInfo user);

	//通过登录表id获取用户信息
	UserInfo getDetail(int id);

	//通过用户对象获取用户全部信息（两个表的信息）
	//无数据返回null
	//String pagesize, String pageindex, String username, String phoneNumber,String name,String identityCardNo, String level
	List<UserInfo> searchAllInfoByUserInfo(Map<String, String> map);

	List<UserInfo> getMemberBySellerId(int sellerid);

	UserInfo getUserInfo(String id);

	void addSeller(String id);

	void deleteSeller(String id);
}
