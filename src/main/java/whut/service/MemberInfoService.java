package whut.service;

import java.util.List;

import whut.pojo.UserInfo;
import whut.utils.ResponseData;

public interface MemberInfoService {

	public ResponseData getList(int status);

	public ResponseData add(UserInfo user);

	public ResponseData delete(int id);

	public ResponseData search(String username, String phoneNumber,String name,String identityCardNo);

	public ResponseData modify(UserInfo user);

	public ResponseData getDetail(int id);
}
