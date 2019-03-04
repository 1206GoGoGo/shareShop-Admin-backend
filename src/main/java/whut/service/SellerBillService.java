package whut.service;

import java.util.List;

import whut.pojo.WithdrawRecord;

public interface SellerBillService {

	public List<WithdrawRecord> getList(String id);

	public void add(WithdrawRecord withdrawRecord);

	

}
