package com.learn.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class JsonParseUtilTest {

	private JsonParseUtil jsonParseUtil = new JsonParseUtil();

	@Test
	void jsonParseUtilTest() {

		Map<String, Object> paramMap = new LinkedHashMap<>();
		
		paramMap.put("userName", "USER_NAME");
		paramMap.put("userID", "USER_ID");
		
		paramMap.put("userCompany.companyId", "COMPANY_ID");
		paramMap.put("userCompany.companyName", "COMPANY_NAME");
		
		paramMap.put("userCompany.companyDetails.companyAddress1", "COMPANY_ADDRESS_1");
		paramMap.put("userCompany.companyDetails.companyAddress2", "COMPANY_ADDRESS_2");
		
		paramMap.put("userCompany.companyDetails.companyPosition.latitude", "54.60");
		paramMap.put("userCompany.companyDetails.companyPosition.longitude", "89.70");

		String result = jsonParseUtil.createJson(paramMap);
		System.out.println(result);
		
		// https://jsonformatter.org/
		
		// Attached
	/*	{
			  "userName": "USER_NAME",
			  "userID": "USER_ID",
			  "userCompany": {
			    "companyId": "COMPANY_ID",
			    "companyName": "COMPANY_NAME",
			    "companyDetails": {
			      "companyAddress2": "COMPANY_ADDRESS_2",
			      "companyAddress1": "COMPANY_ADDRESS_1",
			      "companyPosition": {
			        "latitude": "54.60",
			        "longitude": "89.70"
			       }
			     }
			   }
		 }
	 */
	}
}
