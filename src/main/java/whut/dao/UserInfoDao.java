package whut.dao;

import java.util.List;

import whut.pojo.UserInfo;

public interface UserInfoDao {

	List<UserInfo> getList();

	boolean add(UserInfo user);

	boolean delete(int id);

	boolean modify(UserInfo user);

	UserInfo getDetail(int id);

}
