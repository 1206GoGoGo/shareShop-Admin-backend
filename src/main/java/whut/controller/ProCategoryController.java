package whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.ProductCategory;
import whut.service.ProCategoryService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/pro/category")
public class ProCategoryController {
	
	@Autowired
	public ProCategoryService proCategoryService;
	
	//获取第一层级分类列表
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody Object getList() {
		List<ProductCategory> list = new ArrayList<>();
		list = proCategoryService.getList();
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
	//新增分类
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Object add(@RequestBody ProductCategory productCategory) {		
		if(proCategoryService.ifCategoryExist(productCategory.getCategoryCode()) == null) {
			proCategoryService.add(productCategory);
			return new ResponseData(200,"add success",null);
		}
		return new ResponseData(500,"Fail to add",null);
	}
	
	//修改分类
	@RequestMapping(value = "/modify", method = RequestMethod.POST, consumes= "application/json")
	public @ResponseBody Object modify(@RequestBody ProductCategory productCategory){
		proCategoryService.modify(productCategory);
		return new ResponseData(200,"modify success",null);
	}
	
	//删除分类,其下有子分类时判断
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody Object delete(String id){
		List<ProductCategory> list = new ArrayList<>();
		list = proCategoryService.ifHaveChild(id);
		if(list.size() == 0) {
			proCategoryService.delete(id);
			return new ResponseData(200,"delete success",null);
		}
		return new ResponseData(500,"There are subcategories under this category",null);
	}
	
	//删除分类,其下有子分类也删，修改其下子分类状态都为0
	@RequestMapping(value = "/deleteConfirm", method = RequestMethod.GET)
	public @ResponseBody Object deleteConfirm(String id){
		proCategoryService.delete(id);
		proCategoryService.deleteConfirm(id);
		return new ResponseData(200,"delete success",null);
	}
	
}
