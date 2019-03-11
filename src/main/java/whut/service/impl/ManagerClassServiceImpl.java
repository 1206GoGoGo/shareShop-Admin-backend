package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ManagerCategoryDao;
import whut.pojo.ManagerCategory;
import whut.service.ManagerClassService;
import whut.utils.ResponseData;

@Service
public class ManagerClassServiceImpl implements ManagerClassService {
	
	@Autowired
	private ManagerCategoryDao dao;

	@Override
	public ResponseData getList() {
		List<ManagerCategory> list = dao.getList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
		
	}

	@Override
	public ResponseData add(ManagerCategory managerCategory) {
		//判断同名
		ManagerCategory managerCategoryOld = dao.getIdByName(managerCategory.getName());
		dao.add(managerCategory);
		return new ResponseData(200,"success",null);

	}

	@Override
	public ResponseData modify(ManagerCategory managerCategory) {
		//判断修改的是不是同名
		ManagerCategory managerCategoryOld = dao.getIdByName(managerCategory.getName());
		dao.modify(managerCategory);
		return new ResponseData(200,"success",null);

	}

	@Override
	public ResponseData delete(int id) {
		dao.delete(id);
		return new ResponseData(200,"success",null);

	}

}
