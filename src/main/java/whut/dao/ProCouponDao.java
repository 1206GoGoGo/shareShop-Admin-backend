package whut.dao;

import java.util.List;
import java.util.Map;

import whut.pojo.CouponInfo;
import whut.pojo.CouponLogs;
import whut.pojo.CouponReceive;

public interface ProCouponDao {

	List<CouponInfo> getList();

	void addCoupon(CouponInfo couponInfo);

	CouponInfo getCouponDetailById(String id);

	void deleteCoupon(String id);

	List<CouponReceive> getCouponByUId(String id);

	List<CouponLogs> getCouponLogsList();

	List<CouponReceive> getCouponReceiveList();

	void addCouponLogs(CouponLogs couponLogs);

	CouponLogs getCouponLogsDetail(Map<String, String> map);

	List<CouponLogs> getCouponLogsListByStatus(String status);

	void modifyCouponLogsStatus(String id);

	void addCouponReceive(CouponReceive couponReceive);

	void modifyCouponReceiveStatus(String id);

	

}
