package whut.controller;

import java.util.ArrayList;
import java.util.List;

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
	public @ResponseBody Object getSellerList() {
		List<SellerRegister> list = new ArrayList<>();
		list = sellerInfoService.getSellerList();
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
	
	//添加seller注册信息
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Object add(@RequestBody SellerRegister sellerRegister) {
		sellerInfoService.add(sellerRegister);
		return new ResponseData(200,"add success",null);
	}
	
	
	//删除seller注册信息
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(String id) {
		sellerInfoService.delete(id);
		return new ResponseData(200,"delete success",null);
	}
	
}
