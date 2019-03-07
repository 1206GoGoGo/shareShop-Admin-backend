package whut.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.SellerRegister;
import whut.service.SellerRegisterService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/seller/register")
public class SellerRegisterController {
	/*
	 * 注册成Seller不需要管理员审核，前台判断支付成功即修改用户状态成为店主
	 * 该Controller层无作用
	 */
	@Autowired
	public SellerRegisterService sellerInfoService;
	
	//获取所有seller的登记信息列表
	@RequestMapping(value = "/getSellerList", method = RequestMethod.GET)
	public @ResponseBody ResponseData getSellerList() {
		return sellerInfoService.getSellerList();
	}
	
	
	//添加seller注册信息
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ResponseData add(@RequestBody SellerRegister sellerRegister) {
		return sellerInfoService.add(sellerRegister);
		
	}
	
	
	//删除seller注册信息
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody ResponseData delete(String id) {
		return sellerInfoService.delete(id);
		
	}
	
}
