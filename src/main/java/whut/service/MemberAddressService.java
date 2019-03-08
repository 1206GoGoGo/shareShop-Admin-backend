package whut.service;

import whut.pojo.UserAddr;
import whut.utils.ResponseData;

public interface MemberAddressService {
	
	public ResponseData getListByUserId(int id);

}
