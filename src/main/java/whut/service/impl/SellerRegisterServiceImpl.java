package whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerRegisterDao;
import whut.pojo.SellerRegister;
import whut.service.SellerRegisterService;
import whut.utils.ResponseData;


@Service
public class SellerRegisterServiceImpl implements SellerRegisterService{

	
	@Autowired
	public SellerRegisterDao sellerRegisterDao;

	@Override
	public ResponseData getSellerList() {
		// TODO Auto-generated method stub
		List<SellerRegister> list = new ArrayList<>();
		list = sellerRegisterDao.getSellerList();
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}

	@Override
	public ResponseData add(SellerRegister sellerRegister) {
		// TODO Auto-generated method stub
		sellerRegisterDao.add(sellerRegister);
		return new ResponseData(200,"add success",null);
	}

	@Override
	public ResponseData delete(String id) {
		// TODO Auto-generated method stub
		sellerRegisterDao.delete(id);
		return new ResponseData(200,"delete success",null);
	}

	
	
}
