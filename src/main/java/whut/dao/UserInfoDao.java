package whut.dao;

import java.util.List;

import whut.pojo.UserInfo;

public interface UserInfoDao {

	List<UserInfo> getList(int status);
	
	List<UserInfo> getSellerList();

	void add(UserInfo user) throws Exception;

	//修改用户状态
	boolean delete(int id);

	boolean modify(UserInfo user);

	UserInfo getDetail(int id);

	//通过用户id获取用户全部信息（两个表的信息）
	List<UserInfo> getAllInfoByUserId(int userId);

	//通过用户对象获取用户全部信息（两个表的信息）
	//无数据返回null
	List<UserInfo> searchAllInfoByUserInfo(UserInfo userInfo);

}
