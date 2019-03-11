package whut.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import whut.pojo.OrderDetail;
import whut.pojo.OrderMaster;
import whut.utils.ResponseData;

public interface MemberOrderService {

	public ResponseData getListByUser(String pageindex, String pagesize, String id);

	public ResponseData getListByUserName(String pageindex, String pagesize, String username);

	public ResponseData getListByPro(String pageindex, String pagesize, int id);

	public ResponseData getListByStatus(String pageindex, String pagesize, String status);

	public ResponseData search(String orderNumber);

	public ResponseData getDetailListByOrderId(int orderId);
	
	public ResponseData getDetail(int id);

	public ResponseData modifyOrder(OrderMaster orderMaster);

	public ResponseData modifyPro(OrderDetail orderDetail);

	public ResponseData modifyOrderStatus(@RequestBody String jsonString);

	public ResponseData modifyProStatus(@RequestBody String jsonString);
}
