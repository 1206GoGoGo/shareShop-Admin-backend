package whut.dao;

import java.util.List;
import java.util.Map;

import whut.pojo.OrderDetail;
import whut.pojo.OrderMaster;

public interface OrderDao {

	//String pageindex, String pagesize, String id
	List<OrderMaster> getListByUser(Map<String, String> map);

	//String pageindex, String pagesize, int id
	List<OrderDetail> getListByPro(Map<String, String> map);

	//String pageindex, String pagesize, String status
	List<OrderMaster> getListByStatus(Map<String, String> map);

	OrderMaster searchByOrderNumber(String orderNumber);
	
	OrderMaster getMasterByOrderId(int orderId);

	List<OrderDetail> getDetailListByOrderId(int orderId);

	void modifyOrder(OrderMaster orderMaster);

	void modifyPro(OrderDetail orderDetail);

	//int orderId, Byte status
	void modifyOrderStatus(Map<String, String> map);

	//int orderDetailId, Byte status
	void modifyProStatus(Map<String, String> map);


}
