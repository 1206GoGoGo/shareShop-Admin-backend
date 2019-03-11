package whut.dao;

import whut.pojo.UserLogin;

public interface UserLoginDao {

	//通过用户名获取用户登录表所有字段
	UserLogin getLoginInfo(String username);

}
