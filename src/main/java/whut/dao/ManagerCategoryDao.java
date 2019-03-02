package whut.dao;

import java.util.List;

import whut.pojo.ManagerCategory;

public interface ManagerCategoryDao {

	List<ManagerCategory> getList();

	boolean add(ManagerCategory managerCategory);

	boolean modify(ManagerCategory managerCategory);

	boolean delete(int id);

}
