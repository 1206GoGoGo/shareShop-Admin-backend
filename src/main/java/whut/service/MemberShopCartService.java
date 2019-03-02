package whut.service;

import java.util.List;

import whut.utils.ResponseData;

public interface MemberShopCartService {

	public ResponseData getListByUser(int id);

	public ResponseData getAmountById(int id);
}
