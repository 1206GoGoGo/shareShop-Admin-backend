package whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProCategoryDao;
import whut.pojo.ProductCategory;
import whut.service.ProCategoryService;


@Service
public class ProCategoryServiceImpl implements ProCategoryService{

	@Autowired
	public ProCategoryDao proCategoryDao;
	
	@Override
	public List<ProductCategory> getList() {
		// TODO Auto-generated method stub
		return proCategoryDao.getList();
	}

	@Override
	public void add(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		proCategoryDao.add(productCategory);
	}

	@Override
	public void modify(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		proCategoryDao.modify(productCategory);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		//如果该类别下有产品则无法删除，设置修改状态即可
		proCategoryDao.delete(id);
	}

	@Override
	public ProductCategory ifCategoryExist(String categoryCode) {
		// TODO Auto-generated method stub
		return proCategoryDao.ifCategoryExist(categoryCode);
	}

	@Override
	public List<ProductCategory> ifHaveChild(String id) {
		// TODO Auto-generated method stub
		return proCategoryDao.ifHaveChild(id);
	}

	@Override
	public void deleteConfirm(String id) {
		// TODO Auto-generated method stub
		proCategoryDao.delete(id);
		List<ProductCategory> list = new ArrayList<>();
		list = proCategoryDao.ifHaveChild(id);
		for(int i = 0; i < list.size(); i++) {
			proCategoryDao.delete(list.get(i).getCategoryId().toString());
			List<ProductCategory> list1 = new ArrayList<>();
			list1 = proCategoryDao.ifHaveChild(list.get(i).getCategoryId().toString());
			if(list1.size() > 0) {
				for(int j = 0; j < list1.size(); j++) {
					proCategoryDao.delete(list1.get(j).getCategoryId().toString());
				}
			}
		}
	}

}
