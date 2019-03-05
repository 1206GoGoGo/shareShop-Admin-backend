package whut.dao;

import java.util.List;

import whut.pojo.UserInfo;

public interface UserInfoDao {

<<<<<<< HEAD
	List<UserInfo> getList(int status);
=======
	List<UserInfo> getList();
	
	List<UserInfo> getSellerList();
>>>>>>> d1a6e89de2a9810eda0f8bcec98669866dff2eea

	boolean add(UserInfo user);

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
