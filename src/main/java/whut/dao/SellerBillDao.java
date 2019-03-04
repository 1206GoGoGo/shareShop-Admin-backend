package whut.dao;

import java.util.List;

import whut.pojo.WithdrawRecord;

public interface SellerBillDao {

	public List<WithdrawRecord> getList(String id);

	public void add(WithdrawRecord withdrawRecord);

}
