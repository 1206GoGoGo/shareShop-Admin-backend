package whut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.CouponInfo;
import whut.service.ProCouponService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/pro/coupon")
public class ProCouponController {

	@Autowired
	private ProCouponService proCouponService;
	
	//获取所有优惠券信息
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody ResponseData getList() {
		return proCouponService.getList();
	}
	
	//管理员添加优惠券
	@RequestMapping(value = "/addCoupon", method = RequestMethod.POST, consumes= "application/json")
	public @ResponseBody ResponseData addCoupon(@RequestBody CouponInfo couponInfo) {
		return proCouponService.addCoupon(couponInfo);
	}
	
	//根据优惠券ID查看优惠券详情
	@RequestMapping(value = "/getCouponDetailById", method = RequestMethod.GET)
	public @ResponseBody ResponseData getCouponDetailById(String id) {
		return proCouponService.getCouponDetailById(id);
	}
	
	//管理员删除优惠券（设置优惠券无效）
	@RequestMapping(value = "/deleteCoupon", method = RequestMethod.GET)
	public @ResponseBody ResponseData deleteCoupon(String id) {
		return proCouponService.deleteCoupon(id);
	}
	
	//根据用户Id查看用户领取的未使用(状态为0)优惠券信息
	@RequestMapping(value = "/getCouponByUId", method = RequestMethod.GET)
	public @ResponseBody ResponseData getCouponByUId(String id) {
		return proCouponService.getCouponByUId(id);
	}
	
	//查看优惠券消费记录
	@RequestMapping(value = "/getCouponLogsList", method = RequestMethod.GET)
	public @ResponseBody ResponseData getCouponLogsList() {
		return proCouponService.getCouponLogsList();
	}
	
	//查看优惠券领取记录
	@RequestMapping(value = "/getCouponReceiveList", method = RequestMethod.GET)
	public @ResponseBody ResponseData getCouponReceiveList() {
		return proCouponService.getCouponReceiveList();
	}
	
	
}
