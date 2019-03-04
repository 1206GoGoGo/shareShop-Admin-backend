package whut.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import whut.pojo.WithdrawRecord;
import whut.service.SellerBillService;
import whut.utils.ResponseData;

@Controller
@RequestMapping(value = "/seller/bill")
public class SellerBillController {

	@Autowired
	public SellerBillService sellerBillService;
	
	//获取某一seller的账户余额变动信息
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public @ResponseBody Object getList(String id) {
		List<WithdrawRecord> list = new ArrayList<>();
		list = sellerBillService.getList(id);
		if(list.isEmpty())
			return new ResponseData(400,"No data",null);
		return new ResponseData(200,"success",list);
	}
	
	//添加seller的账户余额变动信息
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Object add(@RequestBody WithdrawRecord withdrawRecord) {
		sellerBillService.add(withdrawRecord);
		return new ResponseData(200,"add success",null);
	}
	
}
