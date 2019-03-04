package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerOrderDao;
import whut.pojo.YieldDetail;
import whut.service.SellerOrderService;

@Service
public class SellerOrderServiceImpl implements SellerOrderService{

	@Autowired
	public SellerOrderDao sellerOrderDao;
	
	@Override
	public List<YieldDetail> getList(String id) {
		// TODO Auto-generated method stub
		return sellerOrderDao.getList(id);
	}

}
