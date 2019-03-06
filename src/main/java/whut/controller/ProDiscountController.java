package whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.ProductDiscount;
import whut.service.ProDiscountService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/pro/discount")
public class ProDiscountController {
	
	@Autowired
	public ProDiscountService proDiscountService;
	
	//获取商品折扣列表
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody ResponseData getList() {
		List<ProductDiscount> list = new ArrayList<>();
		list = proDiscountService.getList();
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
	//根据商品分类id查询折扣
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public @ResponseBody ResponseData search(String id){
		ProductDiscount productDiscount = new ProductDiscount();
		productDiscount = proDiscountService.search(id);
		if(productDiscount == null)
			return new ResponseData(400,"not find",null);
		return new ResponseData(200,"success",productDiscount);
	}
	
	//添加新的折扣信息
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes= "application/json")
	public @ResponseBody ResponseData add(@RequestBody ProductDiscount productDiscount){		
		if(proDiscountService.search(productDiscount.getCategoryId().toString()) == null) {
			proDiscountService.add(productDiscount);
			return new ResponseData(200,"Successfully added",null);
		}
		return new ResponseData(500,"Add failed",null);
	}
	
	//修改折扣信息
	@RequestMapping(value = "/modify", method = RequestMethod.POST, consumes= "application/json")
	public @ResponseBody ResponseData modify(@RequestBody ProductDiscount productDiscount){
		proDiscountService.modify(productDiscount);
		return new ResponseData(200,"modify success",null);
	}
}
