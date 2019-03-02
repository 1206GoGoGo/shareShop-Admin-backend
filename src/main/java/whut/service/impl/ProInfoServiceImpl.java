package whut.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProInfoDao;
import whut.pojo.ProductInfo;
import whut.service.ProInfoService;



@Service
public class ProInfoServiceImpl implements ProInfoService{

	@Autowired
	private ProInfoDao proInfoDao;
	
	@Override
	public List<ProductInfo> getList() {
		// TODO Auto-generated method stub
		return proInfoDao.getList();
	}

	@Override
	public ProductInfo getDetail(String id) {
		// TODO Auto-generated method stub
		return proInfoDao.getDetail(id);
	}

	@Override
	public ProductInfo ifProExist(String id) {
		// TODO Auto-generated method stub
		return proInfoDao.ifProExist(id);
	}
	
	@Override
	public void add(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		proInfoDao.add(productInfo);
	}

	@Override
	public List<ProductInfo> search(String name) {
		// TODO Auto-generated method stub
		return proInfoDao.search(name);
	}

	@Override
	public void modify(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		proInfoDao.modify(productInfo);
	}


	@Override
	public void modifyAuditStatus(String id, String status) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("productId", id);
		map.put("auditStatus", status);
		proInfoDao.modifyAuditStatus(map);
	}

	@Override
	public void modifyShelfStatus(String id, String status) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("productId", id);
		map.put("publishStatus", status);
		proInfoDao.modifyShelfStatus(map);
	}

	@Override
	public List<ProductInfo> getListByCategory(String id) {
		// TODO Auto-generated method stub
		return proInfoDao.getListByCategory(id);
	}

	
	
	
}
