package whut.dao;

import java.util.List;

import whut.pojo.OrderDetail;
import whut.pojo.OrderMaster;

public interface OrderDao {

	List<OrderMaster> getListByUser(int id);

	List<OrderDetail> getListByPro(int id);

	List<OrderMaster> getListByStatus(Byte status);

	OrderMaster getListByStatus(String orderNumber);

	List<OrderDetail> getListByStatus(int orderId);

	List<OrderMaster> getListByOrderId(int orderId);

	boolean modifyOrder(OrderMaster orderMaster);

	boolean modifyPro(OrderDetail orderDetail);

	boolean modifyOrderStatus(int orderId, Byte status);

	boolean modifyProStatus(int orderDetailId, Byte status);

}
