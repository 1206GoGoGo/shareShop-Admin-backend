package whut.service;

import whut.pojo.CouponInfo;
import whut.pojo.CouponLogs;
import whut.pojo.CouponReceive;
import whut.utils.ResponseData;

public interface ProCouponService {

	ResponseData getList();

	ResponseData addCoupon(CouponInfo couponInfo);

	ResponseData getCouponDetailById(String id);

	ResponseData deleteCoupon(String id);

	ResponseData getCouponByUId(String id);

	ResponseData getCouponLogsList();

	ResponseData getCouponReceiveList();

	ResponseData addCouponLogs(CouponLogs couponLogs);

	ResponseData getCouponLogsDetail(String id, String orderNumber);

	ResponseData getCouponLogsListByStatus(String status);

	ResponseData modifyCouponLogsStatus(String id);

	ResponseData addCouponReceive(CouponReceive couponReceive);

	ResponseData modifyCouponReceiveStatus(String id);

}
