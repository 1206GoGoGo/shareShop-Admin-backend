package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ManagerInfoDao;
import whut.pojo.ManagerInfo;
import whut.service.ManagerInfoService;
import whut.utils.ResponseData;
@Service
public class ManagerInfoServiceImpl implements ManagerInfoService {

	@Autowired
	private ManagerInfoDao dao;

	@Override
	public ResponseData getList() {
		List<ManagerInfo> list = dao.getList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData add(ManagerInfo managerInfo) {
		boolean result = dao.add(managerInfo);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

	@Override
	public ResponseData getDetail(int id) {
		ManagerInfo info = dao.getDetail(id);
		if(info != null) {
			return new ResponseData(200,"success",info);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData modify(ManagerInfo managerInfo) {
		boolean result = dao.modify(managerInfo);
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
