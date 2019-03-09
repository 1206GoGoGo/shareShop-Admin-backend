package whut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import whut.service.ProCouponService;

@Controller
@RequestMapping(value = "/pro/coupon")
public class ProCouponController {

	@Autowired
	private ProCouponService proCouponService;
	
	
}
