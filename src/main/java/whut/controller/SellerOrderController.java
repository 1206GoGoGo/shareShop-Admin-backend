package whut.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.service.SellerOrderService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/seller/order")
public class SellerOrderController {
	
	@Autowired
	public SellerOrderService sellerOrderService;
	
	//通过该seller购买的订单信息
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody ResponseData getList(String id) {
		return sellerOrderService.getList(id);
	}
}
