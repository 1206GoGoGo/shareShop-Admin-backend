package whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.SellerBillDao;
import whut.pojo.SellerBill;
import whut.pojo.WithdrawRecord;
import whut.pojo.YieldDetail;
import whut.service.SellerBillService;
import whut.utils.ResponseData;

@Service
public class SellerBillServiceImpl implements SellerBillService{

	@Autowired
	public SellerBillDao sellerBillDao;

	@Override
	public ResponseData getList(String id) {
		// TODO Auto-generated method stub
		List<SellerBill> list = sellerBillDao.getList(id);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData addWithdraw(WithdrawRecord withdrawRecord) {
		// TODO Auto-generated method stub
		sellerBillDao.addWithdraw(withdrawRecord);
		return new ResponseData(200,"add success",null);
	}

	@Override
	public ResponseData addYield(YieldDetail yieldDetail) {
		// TODO Auto-generated method stub
		sellerBillDao.addYield(yieldDetail);
		return new ResponseData(200,"add success",null);
	}

	@Override
	public ResponseData getWithdrawList(String id) {
		// TODO Auto-generated method stub
		List<WithdrawRecord> list = new ArrayList<>();
		list = sellerBillDao.getWithdrawList(id);
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}

	@Override
	public ResponseData getYieldList(String id) {
		// TODO Auto-generated method stub
		List<YieldDetail> list = new ArrayList<>();
		list = sellerBillDao.getYieldList(id);
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
	

	
}
