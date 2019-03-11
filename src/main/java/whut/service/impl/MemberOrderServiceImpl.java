package whut.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import whut.dao.OrderDao;
import whut.dao.UserLoginDao;
import whut.pojo.OrderDetail;
import whut.pojo.OrderMaster;
import whut.pojo.UserAddr;
import whut.service.MemberOrderService;
import whut.utils.JsonUtils;
import whut.utils.ResponseData;

@Service
public class MemberOrderServiceImpl implements MemberOrderService {

	@Autowired
	private OrderDao dao;
	
	@Autowired
	private UserLoginDao loginDao;

	@Override
	public ResponseData getListByUser(String pageindex, String pagesize, String id) {
		Map<String, String> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("id", id);
		List<OrderMaster> list = dao.getListByUser(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}
	
	@Override
	public ResponseData getListByUserName(String pageindex, String pagesize, String username) {
		int id = loginDao.getLoginInfo(username).getUserId();
		if(id == 0) {
			return new ResponseData(4001,"不存在该用户",null);
		}
		
		Map<String, String> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("id", String.valueOf(id));
		
		List<OrderMaster> list = dao.getListByUser(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(4002,"no data",null);
		}
	}

	@Override
	public ResponseData getListByPro(String pageindex, String pagesize, int id) {
		Map<String, String> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("id", String.valueOf(id));
		
		List<OrderDetail> list = dao.getListByPro(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getListByStatus(String pageindex, String pagesize, String status) {
		Map<String, String> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("status", status);
		
		List<OrderMaster> list = dao.getListByStatus(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData search(String orderNumber) {
		OrderMaster orderMaster = dao.searchByOrderNumber(orderNumber);
		if(orderMaster != null) {
			return new ResponseData(200,"success",orderMaster);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}
	
	@Override
	public ResponseData getDetailListByOrderId(int orderId) {
		List<OrderDetail> list = dao.getDetailListByOrderId(orderId);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getDetail(int orderId) {
		OrderMaster  orderMaster = dao.getMasterByOrderId(orderId);
		if(orderMaster != null) {
			return new ResponseData(200,"success",orderMaster);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	/**
	 * 修改订单信息
	 * 需要判断订单状态（订单已关闭等状态、禁止修改）
	 * 订单已发货（就不能修改物流信息<地址单号等>）
	 * 订单完成等状态也不能修改了
	 */
	@Override
	public ResponseData modifyOrder(OrderMaster orderMaster) {
		OrderMaster orderMasterOld = dao.getMasterByOrderId(orderMaster.getOrderId());
		dao.modifyOrder(orderMasterOld);
		return new ResponseData(200,"success",null);
	
	}

	/**
	 * 通过订单状态判断是否允许修改
	 */
	@Override
	public ResponseData modifyPro(OrderDetail orderDetail) {
		dao.modifyPro(orderDetail);
		return new ResponseData(200,"success",null);
	
	}

	/**
	 * 单向：不能从异常修改回来
	 * 待处理、发货、确认收货
	 */
	@Override
	public ResponseData modifyOrderStatus(String jsonString) {
		JsonUtils jsonUtils = new JsonUtils(jsonString);
		String orderId = jsonUtils.getStringValue("orderId");
		String status = jsonUtils.getStringValue("status");
		
		
		Map<String, String> map = new HashMap<>();
		map.put("orderId", orderId);
		map.put("status", status);
		
		
		dao.modifyOrderStatus(map);
		//修改全部子账单状态
		return new ResponseData(200,"success",null);
	
	}

	/**
	 * 判断条件？
	 */
	@Override
	public ResponseData modifyProStatus(String jsonString) {
		JsonUtils jsonUtils = new JsonUtils(jsonString);
		String orderDetailId = jsonUtils.getStringValue("orderDetailId");
		String status = jsonUtils.getStringValue("status");

		Map<String, String> map = new HashMap<>();
		map.put("orderDetailId", orderDetailId);
		map.put("status", status);
		
		dao.modifyProStatus(map);
		return new ResponseData(200,"success",null);
	
	}


}
