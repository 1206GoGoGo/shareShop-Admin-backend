package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerBillDao;
import whut.pojo.WithdrawRecord;
import whut.service.SellerBillService;

@Service
public class SellerBillServiceImpl implements SellerBillService{

	@Autowired
	public SellerBillDao sellerBillDao;
	
	@Override
	public List<WithdrawRecord> getList(String id) {
		// TODO Auto-generated method stub
		return sellerBillDao.getList(id);
	}

	@Override
	public void add(WithdrawRecord withdrawRecord) {
		// TODO Auto-generated method stub
		sellerBillDao.add(withdrawRecord);
	}

	
}
