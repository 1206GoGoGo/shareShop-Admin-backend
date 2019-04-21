package whut.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.StateTaxDao;
import whut.pojo.StateTax;
import whut.service.StateTaxService;
import whut.utils.ResponseData;

@Service
public class StateTaxServiceImpl implements StateTaxService {

	@Autowired
	private StateTaxDao stateTaxDao;
	
	@Override
	public ResponseData getStateTaxList(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("pageindex", pageindex);
		map.put("pagesize", pagesize);
		List<StateTax> list = stateTaxDao.getStateTaxList(map);
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}

	@Override
	public ResponseData getStateTaxById(String id) {
		// TODO Auto-generated method stub
		StateTax stateTax = stateTaxDao.getStateTaxById(id);
		if(stateTax != null)
			return new ResponseData(200,"success",stateTax);
		return new ResponseData(400,"This State is not found!",null);
	}

	@Override
	public ResponseData getStateTaxByName(String name) {
		// TODO Auto-generated method stub
		List<StateTax> stateTax = stateTaxDao.getStateTaxByName(name);
		if(stateTax.size() > 0)
			return new ResponseData(200,"success",stateTax);
		return new ResponseData(400,"This State is not found!",null);
	}

	@Override
	public ResponseData modifyStateTax(String id,String taxRate) {
		// TODO Auto-generated method stub
		StateTax stateTax = stateTaxDao.getStateTaxById(id);
		if(stateTax != null) {
			Map<String,String> map = new HashMap<>();
			map.put("id", id);
			map.put("taxRate", taxRate);
			stateTaxDao.modifyStateTax(map);
			return new ResponseData(200,"success",null);
		}
		return new ResponseData(400,"This State is not found!",null);
	}

}
