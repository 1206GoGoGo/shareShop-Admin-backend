package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProDiscountDao;
import whut.pojo.ProductDiscount;

import whut.service.ProDiscountService;
import whut.utils.ResponseData;


@Service
public class ProDiscountServiceImpl implements ProDiscountService{

	@Autowired
	public ProDiscountDao proDiscountDao;
	
	@Override
	public ResponseData getList() {
		// TODO Auto-generated method stub
		List<ProductDiscount> list = proDiscountDao.getList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData search(String id) {
		// TODO Auto-generated method stub
		ProductDiscount productDiscount = new ProductDiscount();
		productDiscount = proDiscountDao.search(id);
		if(productDiscount == null)
			return new ResponseData(400,"not find",null);
		return new ResponseData(200,"success",productDiscount);
	}

	@Override
	public ResponseData add(ProductDiscount productDiscount) {
		// TODO Auto-generated method stub
		if(proDiscountDao.search(productDiscount.getCategoryId().toString()) == null) {
			proDiscountDao.add(productDiscount);
			return new ResponseData(200,"Successfully added",null);
		}
		return new ResponseData(406,"Add failed",null);
	}

	@Override
	public ResponseData modify(ProductDiscount productDiscount) {
		// TODO Auto-generated method stub
		proDiscountDao.modify(productDiscount);
		return new ResponseData(200,"modify success",null);
	}

}
