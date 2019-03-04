package whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.YieldDetail;
import whut.service.SellerOrderService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/seller/order")
public class SellerOrderController {
	
	@Autowired
	public SellerOrderService sellerOrderService;
	
	//通过该seller购买的订单信息
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody Object getList(String id) {
		List<YieldDetail> list = new ArrayList<>();
		list = sellerOrderService.getList(id);
		if(list.isEmpty())
			return new ResponseData(400, "No data", null);
		return new ResponseData(200, "success",list);
	}
}
