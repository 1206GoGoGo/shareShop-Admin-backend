package whut.service;

import whut.pojo.CouponInfo;
import whut.utils.ResponseData;

public interface ProCouponService {

	ResponseData getList();

	ResponseData addCoupon(CouponInfo couponInfo);

	ResponseData getCouponDetailById(String id);

	ResponseData deleteCoupon(String id);

	ResponseData getCouponByUId(String id);

	ResponseData getCouponLogsList();

	ResponseData getCouponReceiveList();

}
