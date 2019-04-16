package whut.service;

import whut.utils.ResponseData;

public interface StateTaxService {

	ResponseData getStateTaxList(int pageindex, int pagesize);

	ResponseData getStateTaxById(String id);

	ResponseData getStateTaxByName(String name);

	ResponseData modifyStateTax(String id, String taxRate);

}
