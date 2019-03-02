package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.UserInfoDao;
import whut.pojo.UserInfo;
import whut.service.MemberInfoService;
import whut.utils.ResponseData;
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	private UserInfoDao dao;


	@Override
	public ResponseData getList() {
		List<UserInfo> list = dao.getList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData add(UserInfo user) {
		boolean result = dao.add(user);
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

	@Override
	public ResponseData search(String info) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseData modify(UserInfo user) {
		boolean result = dao.modify(user);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

	@Override
	public ResponseData getDetail(int id) {
		UserInfo info = dao.getDetail(id);
		if(info != null) {
			return new ResponseData(200,"success",info);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

}
