package whut.dao;

import java.util.List;

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

}
