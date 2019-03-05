package whut.service;

import whut.utils.ResponseData;

public interface MemberLoginService {

	ResponseData loginin(String jsonString);

	ResponseData loginout(String username);

	ResponseData getPhoneCode(String phoneCode);

	ResponseData getMailCode(String mailCode);



}
