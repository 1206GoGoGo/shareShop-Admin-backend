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

	boolean modifyOrder(OrderMaster orderMaster);

	boolean modifyPro(OrderDetail orderDetail);

	boolean modifyOrderStatus(int orderId, Byte status);

	boolean modifyProStatus(int orderDetailId, Byte status);


}
