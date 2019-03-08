package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.UserInfoDao;
import whut.pojo.UserInfo;
import whut.service.SellerInfoService;
import whut.utils.ResponseData;

@Service
public class SellerInfoServiceImpl implements SellerInfoService{

	@Autowired
	private UserInfoDao sellerInfoDao;
	
	@Override
	public ResponseData getSellerList() {
		// TODO Auto-generated method stub
		List<UserInfo> list = sellerInfoDao.getSellerList();	 
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData addSeller(String id) {
		// TODO Auto-generated method stub
		if(sellerInfoDao.getUserInfo(id).getIsSeller().equals(0)) {			 
			sellerInfoDao.addSeller(id);
			return new ResponseData(200,"success",null);
		}
		return new ResponseData(406,"You are a Seller",null);
	}

	@Override
	public ResponseData deleteSeller(String id) {
		// TODO Auto-generated method stub
		if(sellerInfoDao.getUserInfo(id).getIsSeller().equals(1)) {			 
			sellerInfoDao.deleteSeller(id);
			return new ResponseData(200,"success",null);
		}
		return new ResponseData(406,"You are not a Seller",null);
	}

}
