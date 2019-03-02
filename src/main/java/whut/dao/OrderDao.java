package whut.dao;

import java.util.List;

import whut.pojo.OrderDetail;
import whut.pojo.OrderMaster;

public interface OrderDao {

	List<OrderMaster> getListByUser(int id);

	List<OrderMaster> getListByPro(int id);

	List<OrderMaster> getListByStatus(Byte status);

	OrderMaster getListByStatus(String orderNumber);

	List<OrderDetail> getListByStatus(int orderId);

	List<OrderDetail> getListByOrderId(int orderId);

	boolean modifyOrder(OrderMaster orderMaster);

	boolean modifyPro(OrderDetail orderDetail);

	boolean modifyOrderStatus(int orderId, Byte status);

	boolean modifyProStatus(int orderId, Byte status);

}
