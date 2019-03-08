package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import whut.dao.OrderDao;
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

	@Override
	public ResponseData getListByUser(int id) {
		List<OrderMaster> list = dao.getListByUser(id);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getListByPro(int id) {
		List<OrderDetail> list = dao.getListByPro(id);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getListByStatus(Byte status) {
		List<OrderMaster> list = dao.getListByStatus(status);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData search(String orderNumber) {
		OrderMaster orderMaster = dao.getListByStatus(orderNumber);
		if(orderMaster != null) {
			return new ResponseData(200,"success",orderMaster);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}
	
	@Override
	public ResponseData getDetailListByOrderId(int orderId) {
		List<OrderDetail> list = dao.getListByStatus(orderId);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getDetail(int orderId) {
		List<OrderMaster> list = dao.getListByOrderId(orderId);
		if(list != null) {
			return new ResponseData(200,"success",list);
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
		boolean result = dao.modifyOrder(orderMaster);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

	/**
	 * 通过订单状态判断是否允许修改
	 */
	@Override
	public ResponseData modifyPro(OrderDetail orderDetail) {
		boolean result = dao.modifyPro(orderDetail);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

	/**
	 * 单向：不能从异常修改回来
	 * 待处理、发货、确认收货
	 */
	@Override
	public ResponseData modifyOrderStatus(String jsonString) {
		JsonUtils jsonUtils = new JsonUtils(jsonString);
		int orderId = jsonUtils.getIntValue("orderId");
		Byte status = (byte) jsonUtils.getIntValue("status");
		
		boolean result = dao.modifyOrderStatus(orderId, status);
		//修改全部子账单状态
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

	/**
	 * 判断条件？
	 */
	@Override
	public ResponseData modifyProStatus(String jsonString) {
		JsonUtils jsonUtils = new JsonUtils(jsonString);
		int orderDetailId = jsonUtils.getIntValue("orderId");
		Byte status = (byte) jsonUtils.getIntValue("status");
		
		boolean result = dao.modifyProStatus(orderDetailId, status);
		if(result) {
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(500,"error",null);
		}
	}

}
