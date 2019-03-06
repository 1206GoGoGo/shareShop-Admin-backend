package whut.dao;

import whut.pojo.UserLogin;

public interface UserLoginDao {

	//返回用户id,没有返回0
	int searchByUsername(String username);

	//通过用户名获取用户登录表所有字段
	UserLogin getLoginInfo(String username);

}
