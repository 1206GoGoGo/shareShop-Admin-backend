package whut.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.UserInfoDao;
import whut.dao.UserLoginDao;
import whut.pojo.UserInfo;
import whut.pojo.UserLogin;
import whut.service.MemberInfoService;
import whut.utils.JsonUtils;
import whut.utils.ResponseData;
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	private UserInfoDao dao;

	@Autowired
	private UserLoginDao loginDao;
	
	@Override
	public ResponseData getList(String status,String pageindex, String pagesize) {
		Map<String,String> map = new HashMap<>();
		map.put("status", status);
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		
		List<UserInfo> list = dao.getList(map);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}

	}

	@Override
	public ResponseData add(UserInfo user){
		//判断信息是否冲突
		user.getUserLogin().getUsername();
		user.getPhoneNumber();
		user.getEmail();
		user.getIdentityCardNo();
		//return new ResponseData(4061,"用户信息冲突",null);
		
		//判断密码是否符合规则
		user.getUserLogin().getPassword();
		//return new ResponseData(4062,"密码定义不合规则",null);
		dao.add(user);
		return new ResponseData(200,"success",null);
	}

	@Override
	public ResponseData delete(int id) {
		dao.delete(id);
		return new ResponseData(200,"success",null);
	}

	@Override
	public ResponseData search(String pagesize, String pageindex, String username, String phoneNumber,String name,String identityCardNo, String level) {
		
		//通过用户名直接查询，不再进行其他条件判断
		int userId = 0;
		List<UserInfo> list = new ArrayList<>();
		if(username!=null || username!="") {
			userId = loginDao.getLoginInfo(username).getUserId();
		}
		if(userId!=0) {
			//获取列表
			list.add( dao.getDetail(userId) );
			return new ResponseData(200,"success",list);
		}
			
		//查询，处分页都可能为空
		Map<String,String> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		map.put("username", username);
		map.put("phoneNumber", phoneNumber);
		map.put("name", name);
		map.put("identityCardNo", identityCardNo);
		map.put("level", level);
		
		list = dao.searchAllInfoByUserInfo(map);
		if(list!=null) {
			return new ResponseData(200,"success",list);
		}
		
		return  new ResponseData(400,"no data",null);
	}

	@Override
	public ResponseData modify(UserInfo user) {
		UserInfo userOld = dao.getDetail(user.getUserLogin().getUserId());
		//修改用户信息，密码、登录名、证件号、账户余额禁止修改(编号识别要修改的用户)。需要判断是否满足指定条件，如果用户状态已经是注销状态禁止修改。
		
		
		
		
		dao.modify(user);
		return new ResponseData(200,"success",null);

	}

	@Override
	public ResponseData getDetail(int id) {
		UserInfo info = dao.getDetail(id);
		if(info != null) {
			return new ResponseData(200,"success",info);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getMemberListBySeller(String username) {
		int sellerid = loginDao.getLoginInfo(username).getUserId();
		if(sellerid == 0) {
			return new ResponseData(4061,"no data",null);
		}

		List<UserInfo> list = null;
		list = dao.getMemberBySellerId(sellerid);
		if(list == null) {
			return new ResponseData(4062,"no data",null);
		}
		
		return new ResponseData(200,"success",list);
	}

}
