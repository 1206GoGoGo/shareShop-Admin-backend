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
		boolean result = dao.add(managerCategory);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

	@Override
	public ResponseData modify(ManagerCategory managerCategory) {
		boolean result = dao.modify(managerCategory);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

	@Override
	public ResponseData delete(int id) {
		boolean result = dao.delete(id);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}


}
