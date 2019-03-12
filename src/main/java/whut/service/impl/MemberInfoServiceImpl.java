package whut.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.OrderDao;
import whut.dao.UserInfoDao;
import whut.dao.UserLoginDao;
import whut.pojo.UserInfo;
import whut.pojo.UserLogin;
import whut.service.MemberInfoService;
import whut.utils.ResponseData;
@Service
public class MemberInfoServiceImpl implements MemberInfoService {

	@Autowired
	private UserInfoDao dao;

	@Autowired
	private UserLoginDao loginDao;
	
	@Autowired
	private OrderDao orderDao;
	
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

		String username = user.getUserLogin().getUsername();
		String password = user.getUserLogin().getPassword();
		//判断用户名、密码是否符合规则
		if(username.length()<5) {
			return new ResponseData(4062,"unqualified username",null);}
		if(this.checkPassWordMethod(password)) {
			return new ResponseData(4062,"unqualified password",null);
		}
		
		
		//判断信息是否冲突
		List<UserInfo> list = new ArrayList<>();
		
		if(loginDao.getLoginInfo(username)!=null) {
			return new ResponseData(4061,"username is occupied",null);
		}
		
		String phoneNumber = user.getPhoneNumber();
		list = dao.searchInfoByPhoneNumber(phoneNumber);
		if(list!=null) {
			return new ResponseData(4061,"phoneNumber is occupied",null);
		}
		
		String email = user.getEmail();
		list = dao.searchInfoByEmail(email);
		if(list!=null) {
			return new ResponseData(4061,"email is occupied",null);
		}
		
		String identityCardNo = user.getIdentityCardNo();
		list = dao.searchInfoByIdentityCardNo(identityCardNo);
		if(list!=null) {
			return new ResponseData(4061,"identityCardNo is occupied",null);
		}
		
		//添加用户登录表数据
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(username);
		userLogin.setPassword(password);
		userLogin.setLevel(1);	//设置用户等级
		userLogin.setStatus((byte)1);	//设置用户状态
		
		loginDao.addUser(userLogin);
		
		userLogin = loginDao.getLoginInfo(username);
		
		//给user对象赋值
		user.setUserId(userLogin.getUserId());
		user.setUserLogin(userLogin);

		//添加用户
		dao.add(user);
		return new ResponseData(200,"success",null);
	}

	@Override
	public ResponseData delete(int id) {
		
		UserLogin userLogin = loginDao.getLoginInfoById(id);
		if(userLogin == null) {
			return new ResponseData(406,"该用户不存在",null);
		}
		
		//判断用户状态（已是删除状态禁止删除）
		if(userLogin.getStatus()==0) {
			return new ResponseData(4061,"用户在该状态下禁止删除",null);
		}
		//店主禁止删除（该操作入口禁止删除）
		if(userLogin.getLevel()==3) {
			return new ResponseData(4062,"该用户店主身份禁止删除",null);
		}
		
		//判断该用户是否产生过订单
		Map<String, String> map = new HashMap<>();
		map.put("pageindex", "1");
		map.put("pagesize", "1");
		map.put("id", String.valueOf(id));
		if(orderDao.getListByUser(map)!=null) {
			return new ResponseData(4063,"该用户存在订单信息",null);
		}
		
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
		UserInfo userOld = dao.getDetail(user.getUserId());
		//修改用户信息，密码、登录名、证件号、账户余额禁止修改(编号识别要修改的用户)。需要判断是否满足指定条件，如果用户状态已经是注销状态禁止修改。
		
		//判断当前用户状态
		if( userOld.getUserLogin().getStatus() == 0 ) {
			return new ResponseData(4061,"用户状态异常，禁止修改",null);
		}
		
		//只处理部分参数的修改
		userOld.setName(user.getName());
		userOld.setIdentityCardType(user.getIdentityCardType());
		userOld.setIdentityCardNo(user.getIdentityCardNo());
		userOld.setPhoneNumber(user.getPhoneNumber());
		userOld.setEmail(user.getEmail());
		userOld.setGender(user.getGender());
		userOld.setBirthday(user.getBirthday());
		
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
	
	//密码校验
    private boolean checkPassWordMethod(String str) {
        char[] ch1 = str.toCharArray();
        boolean flag = false;
        int num_count = 0, char_number = 0;
        for (int i = 0; i < ch1.length; i++) {
            if (Character.isDigit(ch1[i]) || Character.isLetter(ch1[i])) {
                if (Character.isDigit(ch1[i]))
                    num_count++;
                else
                    char_number++;
            } else
                break;
        }
        if (num_count >= 2 && char_number >= 8)
            flag = true;
        System.out.println("num_count=" + num_count + ",char_number=" + char_number);
        return flag;
    }

}
