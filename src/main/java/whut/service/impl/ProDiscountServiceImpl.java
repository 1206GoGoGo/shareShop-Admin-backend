package whut.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProDiscountDao;
import whut.pojo.ProductDiscount;
import whut.service.ProDiscountService;


@Service
public class ProDiscountServiceImpl implements ProDiscountService{

	@Autowired
	public ProDiscountDao proDiscountDao;
	
	@Override
	public List<ProductDiscount> getList() {
		// TODO Auto-generated method stub
		return proDiscountDao.getList();
	}

	@Override
	public ProductDiscount search(String id) {
		// TODO Auto-generated method stub
		return proDiscountDao.search(id);
	}

	@Override
	public void add(ProductDiscount productDiscount) {
		// TODO Auto-generated method stub
		proDiscountDao.add(productDiscount);
	}

	@Override
	public void modify(ProductDiscount productDiscount) {
		// TODO Auto-generated method stub
		proDiscountDao.modify(productDiscount);
	}

}
