package whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerOrderDao;
import whut.pojo.YieldDetail;
import whut.service.SellerOrderService;
import whut.utils.ResponseData;

@Service
public class SellerOrderServiceImpl implements SellerOrderService{

	@Autowired
	public SellerOrderDao sellerOrderDao;
	
	@Override
	public ResponseData getList(String id) {
		// TODO Auto-generated method stub
		List<YieldDetail> list = new ArrayList<>();
		list = sellerOrderDao.getList(id);
		if(list.isEmpty())
			return new ResponseData(400, "No data", null);
		return new ResponseData(200, "success",list);
	}

}
