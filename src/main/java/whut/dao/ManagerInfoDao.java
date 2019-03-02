package whut.dao;

import java.util.List;

import whut.pojo.ManagerInfo;

public interface ManagerInfoDao {

	List<ManagerInfo> getList();

	boolean add(ManagerInfo managerInfo);

	ManagerInfo getDetail(int id);

	boolean modify(ManagerInfo managerInfo);

	boolean delete(int id);

}
