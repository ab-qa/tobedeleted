package com.manulife.polaris.bdd.steps.serenity;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manulife.polaris.bdd.steps.WithdrawFromPremiumInAmountDefinitions;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;



public class PolarisUserSteps {
	
	String accessToken = "00D0k0000000S86!ARsAQP.l1ADCO5UPDWggyfLFHPblq5e_UF_y.E1p5fM2ClhVxVhOWvMGzkpvSXqc_Zsuk6fvZ9UxQX6zYExhh19XmdX.Z2wc";
	/*
	String userId = "0050k000000GHzOAAW";
	String country = "PH";
	String policyId = "2812000047";
	String agreementNumber = "0047";
	String policyName = "MiWealth Assurance testing - 2812000047";

	@Step
	public void login_Salesforce(String loginId, String password) {
		SerenityRest.given().
			parameters("grant_type", "password", "client_id", "3MVG959Nd8JMmavRJrkOZkzYpe4nN2FTFz7Vmfp34pzQ7bJL69zQTiuk.TC304npyAyeUfIYrE7rUMJIW74nO", "client_secret", "6158178783780353432", "username", loginId, "password", password).
			baseUri("https://login.salesforce.com/services/oauth2/token").
		when().
			post("/services/oauth2/token").
		then().
		extract().
		response();
		accessToken = "00D0k0000000S86!ARsAQP.l1ADCO5UPDWggyfLFHPblq5e_UF_y.E1p5fM2ClhVxVhOWvMGzkpvSXqc_Zsuk6fvZ9UxQX6zYExhh19XmdX.Z2wc";
	}
	*/
	
	@Step
	public void should_see_policy_infromation(String userId, String country, String policyId, String agreementNumber, String policyName) {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("policyName", policyName);
		jsonAsMap.put("token", accessToken);
		
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("policyId",policyId).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{policyId}/summary").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.policyName", not(equalTo("null"))).
			and().
			body("result.portfolioBalance", not(equalTo("null"))).
			and().
			body("result.portfolioBalance", not(equalTo("null"))).
			and().
			body("result.portfolioCurrency", not(equalTo("null"))).
			and().
			body("result.portfolioPerformance", not(equalTo("null"))).
			and().
			body("result.deathBenfit", not(equalTo("null"))).
			and().
			body("result.deathCurrency", not(equalTo("null"))).
			and().
			body("result.productCode", not(equalTo("null"))).
			and().
			body("result.funds", not(equalTo("null"))).
			and().
			body("result.funds.fundId", not(equalTo("null"))).
			and().
			body("result.funds.shortName", not(equalTo("null"))).
			and().
			body("result.funds.fullName", not(equalTo("null"))).
			and().
			body("result.funds.allocation", not(equalTo("null"))).
			and().
			body("result.funds.currency", not(equalTo("null"))).
			and().
			body("result.funds.balanace", not(equalTo("null"))).
			and().
			body("result.errors", equalTo(null));
	}
	
	@Step
	public void should_see_summary_infromation(String userId, String country, String policyId, String agreementNumber, String policyName) {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("policyName", policyName);
		jsonAsMap.put("token", accessToken);
		
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("policyId",policyId).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{policyId}/detail").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.premiumAmount", not(equalTo("null"))).
			and().
			body("result.currencyCode", not(equalTo("null"))).
			and().
			body("result.inceptionDate", not(equalTo("null"))).
			and().
			body("result.inceptionDate", not(equalTo("null"))).
			and().
			body("result.paymentInfo", not(equalTo("null"))).
			and().
			body("result.paymentInfo.paymentMethod", not(equalTo("null"))).
			and().
			body("result.paymentInfo.paymentFrequence", not(equalTo("null"))).
			and().
			body("result.paymentInfo.bankName", not(equalTo("null"))).
			and().
			body("result.paymentInfo.bankAccNum", not(equalTo("null"))).
			and().
			body("result.beneficiaries", not(equalTo("null"))).
			and().
			body("result.personInsureds.crmId", not(equalTo("null"))).
			and().
			body("result.personInsureds.name", not(equalTo("null"))).
			and().
			body("result.errors", equalTo(null));
	}
	

	@Step
	public void should_see_my_fund_allocation_list(String userId, String agreementComponentNum, String country, String agreementNumber, String token) {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("token", token);
		
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("agreementComponentNum",agreementComponentNum).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{agreementComponentNum}/fundAllocation/getFundAllocation").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.fundCode", not(equalTo("null"))).
			and().
			body("result.fundName", not(equalTo("null"))).
			and().
			body("result.percentAllocation", not(equalTo("null")));

			//and().
			//body("result.errors", nullValue());
	}
	
	
	@Step
	public void should_see_available_Fund_list(String userId, String agreementComponentNum, String country, String agreementNumber, String productCode, String token) {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("productCode", productCode);
		jsonAsMap.put("token", token);
		
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("agreementComponentNum",agreementComponentNum).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{agreementComponentNum}/fundAllocation/getAvailableFundList").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.fundCode", not(equalTo("null"))).
			and().
			body("result.fundName", not(equalTo("null")));
			//and().
			//body("result.errors", nullValue());
	}
	
	@Step
	public void should_see_updated_allocation_list(String userId, String agreementComponentNum, String country, String agreementNumber, String currentUser, String fundCode1, String fundCode2, String fundCode3, String fundCode4, String fundName1, String fundName2, String fundName3, String fundName4, String percentAllocation1, String percentAllocation2, String percentAllocation3, String percentAllocation4, String token) {

		Map<String, Object> jsonAsfundMap1 = new HashMap<>();
		jsonAsfundMap1.put("fundCode",fundCode1);
		jsonAsfundMap1.put("fundName",fundName1);
		jsonAsfundMap1.put("percentAllocation",percentAllocation1);
			
		Map<String, Object> jsonAsfundMap2 = new HashMap<>();
		jsonAsfundMap2.put("fundCode",fundCode2);
		jsonAsfundMap2.put("fundName",fundName2);
		jsonAsfundMap2.put("percentAllocation",percentAllocation2);
		
		ArrayList<HashMap<String,Object>> fundAllocations1 = new ArrayList<HashMap<String,Object>>();
		fundAllocations1.add((HashMap<String, Object>) jsonAsfundMap1);
		
		ArrayList<HashMap<String,Object>> fundAllocations2 = new ArrayList<HashMap<String,Object>>();
		fundAllocations2.add((HashMap<String, Object>) jsonAsfundMap2);
	
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("currentUser", currentUser);
		//jsonAsMap.put("fundAllocations", fundAllocations2);
		jsonAsMap.put("fundAllocations", fundAllocations1);

		jsonAsMap.put("token", token);
	
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("agreementComponentNum",agreementComponentNum).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{agreementComponentNum}/fundAllocation/confirm").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.confirmRefNum", not(equalTo("null")));
			//and().
			//body("result.errors", nullValue());
	}
	

	@Step
	public void should_get_the_error(String userId, String agreementComponentNum, String country, String agreementNumber, String currentUser, String fundCode1, String fundCode2, String fundCode3, String fundCode4, String fundName1, String fundName2, String fundName3, String fundName4, String percentAllocation1, String percentAllocation2, String percentAllocation3, String percentAllocation4, String token) {
	
		
		
		Map<String, Object> jsonAsfundMap1 = new HashMap<>();
		jsonAsfundMap1.put("fundCode",fundCode1);
		jsonAsfundMap1.put("fundName",fundName1);
		jsonAsfundMap1.put("percentAllocation",percentAllocation1);
			
		Map<String, Object> jsonAsfundMap2 = new HashMap<>();
		jsonAsfundMap2.put("fundCode",fundCode2);
		jsonAsfundMap2.put("fundName",fundName2);
		jsonAsfundMap2.put("percentAllocation",percentAllocation2);
		
		
		ArrayList<HashMap<String,Object>> fundAllocations1 = new ArrayList<HashMap<String,Object>>();
		fundAllocations1.add((HashMap<String, Object>) jsonAsfundMap1);
		
		ArrayList<HashMap<String,Object>> fundAllocations2 = new ArrayList<HashMap<String,Object>>();
		fundAllocations2.add((HashMap<String, Object>) jsonAsfundMap2);
	
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("currentUser", currentUser);
		//jsonAsMap.put("fundAllocations", fundAllocations2);
		jsonAsMap.put("fundAllocations", fundAllocations1);

		jsonAsMap.put("token", token);
	
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("agreementComponentNum",agreementComponentNum).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{agreementComponentNum}/fundAllocation/confirm").
		then().
		assertThat().
			statusCode(500);
		
	}
	
	

	@Step
	public void get_my_balance_in_deposit(String userId, String policyId, String country, String agreementNumber,String policyName, String token) {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("token", token);
		
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("policyId",policyId).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{policyId}/currentValue").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.policyNumber", not(equalTo("null"))).
			and().
			body("result.policyName", not(equalTo("null"))).
			and().
			body("result.currentValue", not(equalTo("null"))).
			and().
			body("result.currentValueDate", not(equalTo("null"))).
			and().
			body("result.currencyCode", not(equalTo("null")));

			//and().
			//body("result.errors", nullValue());
	}
	

	@Step
	public void should_see_the_amount_breakdown(String userId, String policyId, String country, String amount,String agreementNumber,String currencyCode,String isFullSurrender,String token,String txnType, String valueType,Float chargesAmount,Float netAmount,Float withdrawAmount,Float minBalance) {
	
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("amount", amount);
		jsonAsMap.put("currencyCode", currencyCode);
		jsonAsMap.put("isFullSurrender", isFullSurrender);
		jsonAsMap.put("token", token);
		jsonAsMap.put("txnType", txnType);
		jsonAsMap.put("valueType", valueType);

	
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("policyId",policyId).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{policyId}/withdraw/validate").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.result", equalTo("Y")).
			and().
			body("result.chargesAmount", equalTo(chargesAmount)).
			and().
			body("result.netAmount", equalTo(netAmount)).
			and().
			body("result.withdrawAmount", equalTo(withdrawAmount)).
			and().
			body("result.minBalance", equalTo(minBalance));
		
	}



	@Step
	public void should_see_the_withdraw_amount_breakdown(String userId, String policyId, String country, String agreementNumber,String bankAccountName,String bankAccountNum,String currencyCode, String currentUser,String isFullSurrender,String token,String txnType,String valueType,Float chargesAmount,Float netAmount,Float withdrawAmount) {
	
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("amount", 0);
		jsonAsMap.put("bankAccountName", bankAccountName);
		jsonAsMap.put("bankAccountNum", bankAccountNum);
		jsonAsMap.put("chargesAmount", netAmount);
		jsonAsMap.put("currencyCode", currencyCode);
		jsonAsMap.put("netAmount", chargesAmount);
		jsonAsMap.put("token", token);
		jsonAsMap.put("txnType", txnType);
		jsonAsMap.put("valueType", valueType);
		jsonAsMap.put("withdrawAmount", withdrawAmount);

	
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("policyId",policyId).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{policyId}/withdraw/confirm").
		then().
		assertThat().
			statusCode(200);
			
	}
	
	
	@Step
	public void should_see_transaction_history(String userId, String country, String policyId, String agreementNumber, String txnFromDate, String txnToDate, String type, String token) {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("agreementNumber", agreementNumber);
		jsonAsMap.put("token", accessToken);
		jsonAsMap.put("txnFromDate", txnFromDate);
		jsonAsMap.put("txnToDate", txnToDate);
		jsonAsMap.put("type", type);
		
		
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-portfolio-service.apps.ext.eas.pcf.manulife.com").
			pathParam("country",country).
			pathParam("userId", userId).
			pathParam("policyId",policyId).
		when().
			post("/portfolio/v1/users/{country}/{userId}/policies/{policyId}/transaction").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.txnDate", not(equalTo("null"))).
			and().
			body("result.policyType", not(equalTo("null"))).
			and().
			body("result.confirmationNum", not(equalTo("null"))).
			and().
			body("result.txnType", not(equalTo("null"))).
			and().
			body("result.amount", not(equalTo("null"))).
			and().
			body("result.grossAmount", not(equalTo("null"))).
			and().
			body("result.chargesAmount", not(equalTo("null"))).
			and().
			body("result.netAmount", not(equalTo("null"))).
			and().
			body("result.currency", not(equalTo("null"))).
			and().
			body("result.txnStatus", not(equalTo("null")));
	}

	
	@Step
	public void should_get_calendar_record_by_id(String id, String country) {
		Map<String, Object>  jsonAsMap = new HashMap<>();
		jsonAsMap.put("country", country);
		
		SerenityRest.given().
			contentType("application/json").
			body(jsonAsMap).
			baseUri("https://polaris-calendar-service.apps.ext.eas.pcf.manulife.com").
			pathParam("id",id).
		when().
			post("/calendar/v1/users/{country}/getCalendarActivityEventById").
		then().
		assertThat().
			statusCode(200).
			and().
			body("result.agreementNumber", not(equalTo("null"))).
			and().
			body("result.agreementComponentNumber", not(equalTo("null"))).
			and().
			body("result.productCode", not(equalTo("null"))).
			and().
			body("result.eventName", not(equalTo("null"))).
			and().
			body("result.actionDate", not(equalTo("null"))).
			and().
			body("result.countryCode", not(equalTo("null"))).
			and().
			body("result.dependencyId", not(equalTo("null"))).
			and().
			body("result.policyHolderCrmId", not(equalTo("null"))).
			and().
			body("result.status", not(equalTo("null"))).
			and().
			body("result.lastUpdateTime", not(equalTo("null")));
	}
	
}