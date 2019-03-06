package whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.ProductComment;
import whut.service.ProCommentService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/pro/comment")
public class ProCommentController {
	
	@Autowired
	public ProCommentService proCommentService;
	
	//根据商品id获取评论列表
	@RequestMapping(value = "/getListByProduct", method = RequestMethod.GET)
	public @ResponseBody ResponseData getListByProduct(String id) {
		List<ProductComment> list = new ArrayList<>();
		list = proCommentService.getListByProduct(id);
		if(list.isEmpty())
			return new ResponseData(400,"No Comments",null);
		return new ResponseData(200,"success",list);
	}
	
	//根据用户id查询用户评论列表
	@RequestMapping(value = "/getListByUser", method = RequestMethod.GET)
	public @ResponseBody ResponseData getListByUser(String id) {
		List<ProductComment> list = new ArrayList<>();
		list = proCommentService.getListByUser(id);
		if(list.isEmpty())
			return new ResponseData(400,"No Comments",null);
		return new ResponseData(200,"success",list);
	}
	
	//新增评论第一次
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseData add(@RequestBody ProductComment productComment) {
		proCommentService.add(productComment);
		return new ResponseData(200,"add success",null);
	}
	
	//根据评论id追加评论第二次
	@RequestMapping(value = "/addAgain", method = RequestMethod.GET)
	public @ResponseBody ResponseData addAgain(String id, String content) {
		ProductComment productComment = proCommentService.getCommentById(id);
		if(productComment.getSecondContent() == null) {
			proCommentService.addAgain(id, content);
			return new ResponseData(200,"add success",null);
		}
		return new ResponseData(500,"Sorry,you can't evaluate again",null);
	}
	
	//删除评论,修改评论状态
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody ResponseData delete(String id){
		proCommentService.delete(id);
		return new ResponseData(200,"delete success",null);
	}
}
