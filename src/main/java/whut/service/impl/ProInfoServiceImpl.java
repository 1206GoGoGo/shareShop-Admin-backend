package whut.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProInfoDao;
import whut.pojo.ProductInfo;
import whut.service.ProInfoService;
import whut.utils.ResponseData;



@Service
public class ProInfoServiceImpl implements ProInfoService{

	@Autowired
	private ProInfoDao proInfoDao;
	
	@Override
	public ResponseData getList() {
		// TODO Auto-generated method stub
		List<ProductInfo> list = proInfoDao.getList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getDetail(String id) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = proInfoDao.getDetail(id);
		if(productInfo != null) {
			return new ResponseData(200,"success",productInfo);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	
	@Override
	public ResponseData add(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		if(proInfoDao.getDetailByCode(productInfo.getProductCode()) == null) {
			proInfoDao.add(productInfo);
			return new ResponseData(200,"success",null);
		}else {
			return new ResponseData(406,"parameters incorrect",null);
		}
	}

	@Override
	public ResponseData search(String name) {
		// TODO Auto-generated method stub
		List<ProductInfo> list = new ArrayList<>();
		list = proInfoDao.search(name);
		if(list.isEmpty())
			return new ResponseData(400,"No match was found",null);
		return new ResponseData(200,"success",list);
	}

	@Override
	public ResponseData modify(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		proInfoDao.modify(productInfo);
		return new ResponseData(200,"modify success",null);
	}


	@Override
	public ResponseData modifyAuditStatus(String id, String status) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("productId", id);
		map.put("auditStatus", status);
		proInfoDao.modifyAuditStatus(map);
		return new ResponseData(200,"modifyAuditStatus success",null);
	}

	@Override
	public ResponseData modifyShelfStatus(String id, String status) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("productId", id);
		map.put("publishStatus", status);
		proInfoDao.modifyShelfStatus(map);
		return new ResponseData(200,"modifyShelfStatus success",null);
	}

	@Override
	public ResponseData getListByCategory(String id) {
		// TODO Auto-generated method stub
		List<ProductInfo> list = new ArrayList<>();
		list = proInfoDao.getListByCategory(id);
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}

	@Override
	public ResponseData getDetailByCode(String id) {
		// TODO Auto-generated method stub
		ProductInfo productInfo = proInfoDao.getDetailByCode(id);
		if(productInfo != null) {
			return new ResponseData(200,"success",productInfo);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getUncheckedList() {
		// TODO Auto-generated method stub
		List<ProductInfo> list = proInfoDao.getUncheckedList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getOffShelfCategory() {
		// TODO Auto-generated method stub
		List<ProductInfo> list = proInfoDao.getOffShelfCategory();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}	
	
}
