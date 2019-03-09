package whut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import whut.dao.ProCouponDao;
import whut.service.ProCouponService;

@Service
public class ProCouponServiceImpl implements ProCouponService{
	
	@Autowired
	private ProCouponDao proCouponDao;
	
	
}
