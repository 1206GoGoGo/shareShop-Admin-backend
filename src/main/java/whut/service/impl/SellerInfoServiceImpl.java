package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerInfoDao;
import whut.pojo.SellerRegister;
import whut.pojo.UserInfo;
import whut.service.SellerInfoService;


@Service
public class SellerInfoServiceImpl implements SellerInfoService{

	
	@Autowired
	public SellerInfoDao sellerInfoDao;

	@Override
	public List<UserInfo> getList() {
		// TODO Auto-generated method stub
		return sellerInfoDao.getList();
	}

	@Override
	public UserInfo getDetail(String id) {
		// TODO Auto-generated method stub
		return sellerInfoDao.getDetail(id);
	}

	@Override
	public void modify(UserInfo userInfo) {
		// TODO Auto-generated method stub
		sellerInfoDao.modify(userInfo);
	}

	@Override
	public void add(SellerRegister sellerRegister) {
		// TODO Auto-generated method stub
		sellerInfoDao.add(sellerRegister);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		sellerInfoDao.delete(id);
	}
	
	
}
