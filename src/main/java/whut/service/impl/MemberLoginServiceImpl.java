package whut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.UserLoginDao;
import whut.pojo.UserLogin;
import whut.service.MemberLoginService;
import whut.utils.JsonUtils;
import whut.utils.ResponseData;
@Service
public class MemberLoginServiceImpl implements MemberLoginService {
	
	@Autowired
	private UserLoginDao loginDao;
	
	@Override
	public ResponseData loginin(String jsonString) {
		
		JsonUtils jsonUtils = new JsonUtils(jsonString);
		String username = jsonUtils.getStringValue("username");
		
		UserLogin userLogin = loginDao.getLoginInfo(username);
		
		//做验证
		
		//同意后在session中保存用户信息
		
		return new ResponseData(200,"no data",null);
	}

	@Override
	public ResponseData loginout(String username) {
		//直接登出
		return new ResponseData(200,"success",null);
	}

	@Override
	public ResponseData getPhoneCode(String phoneCode) {
		return new ResponseData(200,"success","成功发送验证码，请查收");
	}

	@Override
	public ResponseData getMailCode(String mailCode) {
		return new ResponseData(200,"success","成功发送验证码，请查收");
	}

}
