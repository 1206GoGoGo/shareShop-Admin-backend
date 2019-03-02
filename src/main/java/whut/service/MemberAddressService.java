package whut.service;

import whut.pojo.UserAddr;
import whut.utils.ResponseData;

public interface MemberAddressService {
	
	public ResponseData getListByUserId(int id);

	public ResponseData add(UserAddr userAddr);

	public ResponseData delete(int id);

	public ResponseData modify(UserAddr userAddr);

}
