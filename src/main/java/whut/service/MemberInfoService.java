package whut.service;


import whut.pojo.UserInfo;
import whut.utils.ResponseData;

public interface MemberInfoService {

	public ResponseData getList(int status,int pageindex, int pagesize);

	public ResponseData add(UserInfo user);

	public ResponseData delete(String jsonString);

	public ResponseData search(int pagesize, int pageindex, String username, String phoneNumber,String name,String identityCardNo, String level);

	public ResponseData modify(UserInfo user);

	public ResponseData getDetail(int id);

	public ResponseData getMemberListBySeller(String username);
}
