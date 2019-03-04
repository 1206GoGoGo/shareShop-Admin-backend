package whut.dao;

import java.util.List;

import whut.pojo.YieldDetail;

public interface SellerOrderDao {

	public List<YieldDetail> getList(String id);

}
