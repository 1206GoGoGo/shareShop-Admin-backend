package whut.dao;

import whut.pojo.UserLogin;

public interface UserLoginDao {

	//通过用户名获取用户登录表所有字段
	UserLogin getLoginInfo(String username);

	void addUser(UserLogin userLogin);

	//通过id获取对象
	UserLogin getLoginInfoById(Integer userId);

	//获取数量。不存在返回0
	int getLoginInfoAmountByLevel(int level);
	
	void addSeller(String id);

	void deleteSeller(String id);

	//通过传入的日期2019-04-04获取改天注册用户数\seller

	//普通用户
	int getCountADayForUser(String day);

	//会员
	int getCountADayForMember(String day);

	//seller
	int getCountADayForSeller(String day);
}
