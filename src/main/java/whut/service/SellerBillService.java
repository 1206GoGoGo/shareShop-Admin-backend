package whut.service;

import java.util.List;

import whut.pojo.SellerBill;
import whut.pojo.WithdrawRecord;
import whut.pojo.YieldDetail;

public interface SellerBillService {

	public List<SellerBill> getList(String id);

	public void addWithdraw(WithdrawRecord withdrawRecord);

	public void addYield(YieldDetail yieldDetail);

	public List<WithdrawRecord> getWithdrawList(String id);

	public List<YieldDetail> getYieldList(String id);

	

	

}
