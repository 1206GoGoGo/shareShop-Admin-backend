package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerInfoDao;
import whut.pojo.UserInfo;
import whut.service.SellerInfoService;
import whut.utils.ResponseData;

@Service
public class SellerInfoServiceImpl implements SellerInfoService{

	@Autowired
	private SellerInfoDao sellerInfoDao;
	
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
	public UserInfo getUserInfo(String id) {
		// TODO Auto-generated method stub
		return sellerInfoDao.getUserInfo(id);
	}
	
	@Override
	public ResponseData addSeller(String id) {
		// TODO Auto-generated method stub
		//判断是否是店主
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
