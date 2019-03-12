package whut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.service.MemberLoginService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/manager/login")
public class ManagerLoginController {
	@Autowired
	private MemberLoginService memberLoginService;
	
	@RequestMapping(value = "/in", method = RequestMethod.POST)
	public @ResponseBody ResponseData loginin(@RequestBody String jsonString) {
		return  memberLoginService.loginin(jsonString);
	}
	
	@RequestMapping(value = "/out", method = RequestMethod.GET)
	public @ResponseBody ResponseData loginout(String username) {
		return  memberLoginService.loginout(username);
	}
	
	@RequestMapping(value = "/getPhoneCode", method = RequestMethod.GET)
	public @ResponseBody ResponseData getPhoneCode(String phoneCode) {
		return  memberLoginService.getPhoneCode(phoneCode);
	}
	
	@RequestMapping(value = "/getMailCode", method = RequestMethod.GET)
	public @ResponseBody ResponseData getMailCode(String mailCode) {
		return  memberLoginService.getMailCode(mailCode);
	}
}
