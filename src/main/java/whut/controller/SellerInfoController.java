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
import whut.pojo.UserInfo;
import whut.service.SellerInfoService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/seller/info")
public class SellerInfoController {
	
	@Autowired
	public SellerInfoService sellerInfoService;
	
	
	
	//获取所有seller的信息列表
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody Object getList() {
		List<UserInfo> list = new ArrayList<>();
		list = sellerInfoService.getList();
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
	//获取某一seller信息详情
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	public @ResponseBody Object getDetail(String id) {
		UserInfo userInfo = new UserInfo();
		userInfo = sellerInfoService.getDetail(id);
		if(userInfo == null)
			return new ResponseData(500,"Not find",null);
		return new ResponseData(200,"success",userInfo);
	}
	
	//修改seller信息
	@RequestMapping(value = "/modify", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Object modify(@RequestBody UserInfo userInfo) {
		sellerInfoService.modify(userInfo);
		return new ResponseData(200,"modify success",null);
	}
	
	//添加seller注册信息
	//seller是否需要管理员审核通过,是则UserInfo表暂不变，否则UserInfo表要变
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Object add(@RequestBody SellerRegister sellerRegister) {
		sellerInfoService.add(sellerRegister);
		return new ResponseData(200,"add success",null);
	}
	
	
	//删除seller，修改SellerRegister表用户的状态
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(String id) {
		sellerInfoService.delete(id);
		return new ResponseData(200,"delete success",null);
	}
	
}
