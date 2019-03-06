package whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.ProductInfo;
import whut.service.ProInfoService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/pro/info")
public class ProInfoController {
	
	@Autowired
	public ProInfoService proInfoService;
	
	
	//获取所有商品列表
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody ResponseData getList() {
		List<ProductInfo> list = new ArrayList<>();
		list = proInfoService.getList();
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
	//根据商品id获取某商品详情
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	public @ResponseBody ResponseData getDetail(String id){
		ProductInfo productInfo = new ProductInfo();
		productInfo = proInfoService.getDetail(id);
		if(productInfo == null)
			return new ResponseData(400,"not find",null);
		return new ResponseData(200,"success",productInfo);
	}
	
	//根据商品码id获取某商品详情
	@RequestMapping(value = "/getDetailByCode", method = RequestMethod.GET)
	public @ResponseBody ResponseData getDetailByCode(String id){
		ProductInfo productInfo = new ProductInfo();
		productInfo = proInfoService.getDetailByCode(id);
		if(productInfo == null)
			return new ResponseData(400,"not find",null);
		return new ResponseData(200,"success",productInfo);
	}
	
	//添加新商品信息
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes= "application/json")
	public @ResponseBody ResponseData add(@RequestBody ProductInfo productInfo){		
		if(proInfoService.getDetailByCode(productInfo.getProductCode()) == null) {
			proInfoService.add(productInfo);
			return new ResponseData(200,"Successfully added",null);
		}
		return new ResponseData(500,"Add failed",null);
	}
	
	//根据商品名称查找商品
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody ResponseData search(String name){
		List<ProductInfo> list = new ArrayList<>();
		list = proInfoService.search(name);
		if(list.isEmpty())
			return new ResponseData(400,"No match was found",null);
		return new ResponseData(200,"success",list);
	}
	
	//修改某商品属性
	@RequestMapping(value = "/modify", method = RequestMethod.POST, consumes= "application/json")
	public @ResponseBody ResponseData modify(@RequestBody ProductInfo productInfo){
		proInfoService.modify(productInfo);
		return new ResponseData(200,"modify success",null);
	}
	
	//根据商品id修改某商品审核状态
	@RequestMapping(value = "/modifyAuditStatus", method = RequestMethod.GET)
	public @ResponseBody ResponseData modifyAuditStatus(String id, String status){
		proInfoService.modifyAuditStatus(id, status);
		return new ResponseData(200,"modifyAuditStatus success",null);
	}
	
	//根据商品id修改某商品上下架状态
	@RequestMapping(value = "/modifyShelfStatus", method = RequestMethod.GET)
	public @ResponseBody ResponseData modifyShelfStatus(String id, String status){
		proInfoService.modifyShelfStatus(id, status);
		return new ResponseData(200,"modifyShelfStatus success",null);
	}
	
	//根据分类获取商品列表
	@RequestMapping(value = "/getListByCategory", method = RequestMethod.GET)
	public @ResponseBody ResponseData getListByCategory(String id){
		List<ProductInfo> list = new ArrayList<>();
		list = proInfoService.getListByCategory(id);
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
}
	

