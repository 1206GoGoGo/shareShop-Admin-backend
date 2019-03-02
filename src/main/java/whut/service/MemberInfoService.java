package whut.service;

import java.util.List;

import whut.pojo.UserInfo;
import whut.utils.ResponseData;

public interface MemberInfoService {

	public ResponseData getList();

	public ResponseData add(UserInfo user);

	public ResponseData delete(int id);

	public ResponseData search(String info);

	public ResponseData modify(UserInfo user);

	public ResponseData getDetail(int id);
}
