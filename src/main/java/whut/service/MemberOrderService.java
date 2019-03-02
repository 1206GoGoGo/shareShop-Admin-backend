package whut.service;

import java.util.List;

import whut.pojo.OrderDetail;
import whut.pojo.OrderMaster;
import whut.utils.ResponseData;

public interface MemberOrderService {

	public ResponseData getListByUser(int id);

	public ResponseData getListByPro(int id);

	public ResponseData getListByStatus(Byte status);

	public ResponseData search(String orderNumber);

	public ResponseData getDetailListByOrderId(int orderId);
	
	public ResponseData getDetail(int id);

	public ResponseData modifyOrder(OrderMaster orderMaster);

	public ResponseData modifyPro(OrderDetail orderDetail);

	public ResponseData modifyOrderStatus(int orderId, Byte status);

	public ResponseData modifyProStatus(int orderDetailId, Byte status);
}
