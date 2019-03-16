package whut.dao;

import whut.pojo.UserLogin;

public interface UserLoginDao {

	//通过用户名获取用户登录表所有字段
	UserLogin getLoginInfo(String username);

	void addUser(UserLogin userLogin);

	//通过id获取对象
	UserLogin getLoginInfoById(Integer userId);


}
