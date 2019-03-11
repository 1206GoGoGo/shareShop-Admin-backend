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
		//判断用户名是否重复
		dao.add(managerInfo);
		return new ResponseData(200,"success",null);

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
		//判断参数等问题
		dao.getDetail(managerInfo.getUserId());
		//
		dao.modify(managerInfo);
		return new ResponseData(200,"success",null);
	}

	@Override
	public ResponseData delete(int id) {
		dao.delete(id);
		return new ResponseData(200,"success",null);

	}
	


}
