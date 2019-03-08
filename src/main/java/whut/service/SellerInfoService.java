package whut.service;

import whut.utils.ResponseData;

public interface SellerInfoService {

	ResponseData getSellerList();

	ResponseData addSeller(String id);

	ResponseData deleteSeller(String id);

}
