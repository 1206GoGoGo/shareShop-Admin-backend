package whut.service;


import whut.pojo.UserInfo;
import whut.utils.ResponseData;

public interface MemberInfoService {

	public ResponseData getList(int status,int pageindex, int pagesize);

	public ResponseData add(UserInfo user);

	public ResponseData delete(int id);

	public ResponseData search(String pagesize, String pageindex, String username, String phoneNumber,String name,String identityCardNo, String level);

	public ResponseData modify(UserInfo user);

	public ResponseData getDetail(int id);

	public ResponseData getMemberListBySeller(String username);
}
