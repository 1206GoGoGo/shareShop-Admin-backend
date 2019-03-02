package whut.dao;

import java.util.List;

import whut.pojo.UserAddr;

public interface UserAddrDao {

	List<UserAddr> getListByUserId(int id);

	boolean add(UserAddr userAddr);

	boolean delete(int id);

	boolean modify(UserAddr userAddr);

}
