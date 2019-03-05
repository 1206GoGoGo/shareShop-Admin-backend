package whut.dao;

import java.util.List;

import whut.pojo.SellerBill;
import whut.pojo.WithdrawRecord;
import whut.pojo.YieldDetail;

public interface SellerBillDao {

	public void addWithdraw(WithdrawRecord withdrawRecord);

	public List<SellerBill> getList(String id);

	public void addYield(YieldDetail yieldDetail);

	public List<WithdrawRecord> getWithdrawList(String id);

	public List<YieldDetail> getYieldList(String id);

}
