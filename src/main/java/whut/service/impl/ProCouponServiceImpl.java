package whut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProCouponDao;
import whut.pojo.CouponInfo;
import whut.pojo.CouponLogs;
import whut.pojo.CouponReceive;
import whut.service.ProCouponService;
import whut.utils.ResponseData;

@Service
public class ProCouponServiceImpl implements ProCouponService{
	
	@Autowired
	private ProCouponDao proCouponDao;

	@Override
	public ResponseData getList() {
		// TODO Auto-generated method stub
		List<CouponInfo> list = new ArrayList<>();
		list = proCouponDao.getList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData addCoupon(CouponInfo couponInfo) {
		// TODO Auto-generated method stub
		proCouponDao.addCoupon(couponInfo);
		return new ResponseData(200,"success",null);
	}

	@Override
	public ResponseData getCouponDetailById(String id) {
		// TODO Auto-generated method stub
		CouponInfo couponInfo = proCouponDao.getCouponDetailById(id);
		return new ResponseData(200,"success",couponInfo);
	}

	@Override
	public ResponseData deleteCoupon(String id) {
		// TODO Auto-generated method stub
		proCouponDao.deleteCoupon(id);
		return new ResponseData(200,"success",null);
	}

	@Override
	public ResponseData getCouponByUId(String id) {
		// TODO Auto-generated method stub
		List<CouponReceive> list = new ArrayList<>();
		list = proCouponDao.getCouponByUId(id);
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getCouponLogsList() {
		// TODO Auto-generated method stub
		List<CouponLogs> list =	new ArrayList<>();
		list = proCouponDao.getCouponLogsList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}

	@Override
	public ResponseData getCouponReceiveList() {
		// TODO Auto-generated method stub
		List<CouponReceive> list =	new ArrayList<>();
		list = proCouponDao.getCouponReceiveList();
		if(list != null) {
			return new ResponseData(200,"success",list);
		}else {
			return new ResponseData(400,"no data",null);
		}
	}
	
	
}
