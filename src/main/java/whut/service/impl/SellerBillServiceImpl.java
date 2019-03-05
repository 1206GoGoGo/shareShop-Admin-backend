package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerBillDao;
import whut.pojo.SellerBill;
import whut.pojo.WithdrawRecord;
import whut.pojo.YieldDetail;
import whut.service.SellerBillService;

@Service
public class SellerBillServiceImpl implements SellerBillService{

	@Autowired
	public SellerBillDao sellerBillDao;

	@Override
	public List<SellerBill> getList(String id) {
		// TODO Auto-generated method stub
		return sellerBillDao.getList(id);
	}

	@Override
	public void addWithdraw(WithdrawRecord withdrawRecord) {
		// TODO Auto-generated method stub
		sellerBillDao.addWithdraw(withdrawRecord);
	}

	@Override
	public void addYield(YieldDetail yieldDetail) {
		// TODO Auto-generated method stub
		sellerBillDao.addYield(yieldDetail);
	}

	@Override
	public List<WithdrawRecord> getWithdrawList(String id) {
		// TODO Auto-generated method stub
		return sellerBillDao.getWithdrawList(id);
	}

	@Override
	public List<YieldDetail> getYieldList(String id) {
		// TODO Auto-generated method stub
		return sellerBillDao.getYieldList(id);
	}
	
	

	
}
