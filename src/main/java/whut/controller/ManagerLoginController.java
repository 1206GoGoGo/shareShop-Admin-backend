package whut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.service.MemberInfoService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/manager/login")
public class ManagerLoginController {
	@Autowired
	private MemberInfoService userService;
	
	@RequestMapping(value = "/byPassword", method = RequestMethod.GET)
	public @ResponseBody Object byPassword() {
		return  new ResponseData(400, "success", null);
	}
	
	@RequestMapping(value = "/byVerifyCode", method = RequestMethod.GET)
	public @ResponseBody Object byVerifyCode() {
		return  new ResponseData(400, "success", null);
	}
}
