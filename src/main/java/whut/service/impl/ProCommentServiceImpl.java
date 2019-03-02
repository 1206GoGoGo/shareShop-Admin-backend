package whut.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProCommentDao;
import whut.pojo.ProductComment;
import whut.service.ProCommentService;



@Service
public class ProCommentServiceImpl implements ProCommentService{

	@Autowired
	public ProCommentDao proCommentDao;

	@Override
	public List<ProductComment> getListByProduct(String id) {
		// TODO Auto-generated method stub
		return proCommentDao.getListByProduct(id);
	}

	@Override
	public List<ProductComment> getListByUser(String id) {
		// TODO Auto-generated method stub
		return proCommentDao.getListByUser(id);
	}

	@Override
	public void add(ProductComment productComment) {
		// TODO Auto-generated method stub
		proCommentDao.add(productComment);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		proCommentDao.delete(id);
	}

	@Override
	public void addAgain(String id, String content) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("commentId", id);
		map.put("secondContent", content);
		proCommentDao.addAgain(map);
	}

	@Override
	public ProductComment getCommentById(String id) {
		// TODO Auto-generated method stub
		return proCommentDao.getCommentById(id);
	}
	
}
