package whut.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.OrderReturnDao;
import whut.pojo.ReturnRecord;
import whut.service.MemberOrderReturnService;
import whut.utils.ResponseData;

@Service
public class MemberOrderReturnServiceImpl implements MemberOrderReturnService {

	@Autowired
	private OrderReturnDao orderReturnDao;
	
	@Override
	public ResponseData getListByUser(Integer pageindex, Integer pagesize, Integer userId) {
		if(pageindex == null) {
			pageindex = 0;
		}
		if(pagesize == null) {
			pagesize = 20;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("userId", userId);
		List<ReturnRecord> list = orderReturnDao.getListByUser(map);
		if(list.isEmpty()) {
			return new ResponseData(400,"no data satify request",null);
		}else {
			return new ResponseData(200,"success",list);
		}
	}

	@Override
	public ResponseData getListByStatus(Integer pageindex, Integer pagesize, String statusAll) {
		if(pageindex == null) {
			pageindex = 0;
		}
		if(pagesize == null) {
			pagesize = 20;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("statusAll", statusAll);
		List<ReturnRecord> list = orderReturnDao.getListByStatus(map);
		if(list.isEmpty()) {
			return new ResponseData(400,"no data satify request",null);
		}else {
			return new ResponseData(200,"success",list);
		}
	}

	@Override
	public ResponseData getListByOrderId(Integer orderId) {
		List<ReturnRecord> list = orderReturnDao.getListByOrderId(orderId);
		if(list.isEmpty()) {
			return new ResponseData(400,"no data satify request",null);
		}else {
			return new ResponseData(200,"success",list);
		}
	}

	@Override
	public ResponseData getListByReturnType(Integer pageindex, Integer pagesize, Integer type) {
		if(pageindex == null) {
			pageindex = 0;
		}
		if(pagesize == null) {
			pagesize = 20;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("type", type);
		List<ReturnRecord> list = orderReturnDao.getListByReturnType(map);
		if(list.isEmpty()) {
			return new ResponseData(400,"no data satify request",null);
		}else {
			return new ResponseData(200,"success",list);
		}
	}
}