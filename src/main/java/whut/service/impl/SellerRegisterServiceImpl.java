package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerRegisterDao;
import whut.pojo.SellerRegister;
import whut.pojo.UserInfo;
import whut.service.SellerRegisterService;


@Service
public class SellerRegisterServiceImpl implements SellerRegisterService{

	
	@Autowired
	public SellerRegisterDao sellerRegisterDao;

	@Override
	public List<SellerRegister> getSellerList() {
		// TODO Auto-generated method stub
		return sellerRegisterDao.getSellerList();
	}

	@Override
	public void add(SellerRegister sellerRegister) {
		// TODO Auto-generated method stub
		sellerRegisterDao.add(sellerRegister);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		sellerRegisterDao.delete(id);
	}

	
	
}
