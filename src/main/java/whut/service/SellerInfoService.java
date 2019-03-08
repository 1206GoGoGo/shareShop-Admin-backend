package whut.service;

import whut.pojo.UserInfo;
import whut.utils.ResponseData;

public interface SellerInfoService {

	public ResponseData getSellerList();

	public ResponseData addSeller(String id);

	UserInfo getUserInfo(String id);

	public ResponseData deleteSeller(String id);

}
