package com.manulife.polaris.bdd.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.manulife.polaris.bdd.steps.serenity.PolarisUserSteps;

public class FilteringTransactionHistoryDefinitions {

	String userId;
	String country;
	String policyId;
	String agreementNumber;
	String policyName;
	String token;
	String txnFromDate;
	String txnToDate;
	String type;
	
    @Steps
    PolarisUserSteps anna;

    @Given("^I login the account with the user ID (.*), policyID (.*), country code (.*), agreementNumber (.*) and token (.*)$")
    public void givenTheUserIsLogin(String userId, String policyId, String country, String agreementNumber, String token) {
    	this.userId = userId;
    	this.policyId = policyId;
    	this.country = country;
    	this.agreementNumber = agreementNumber;
    	this.token = token;
    }
    
    @When("^I input the From date as (.*) and the To date as (.*)$")
   public void i_input_the_From_date_as_T_Z_and_the_To_date_as_T_Z(String txnFromDate, String txnToDate) {
    	this.txnFromDate = txnFromDate;
    	this.txnToDate = txnToDate;
    }

    @And("^select the account type as (.*)$")
    public void select_the_account_type_as_all(String type) {
    	this.type = type;
    }
    
    @Then("^I should able to see my transaction history within (.*) and (.*)$")
    public void i_can_see_transaction_history(String txnFromDate, String txnToDate) {
		//    	anna.getPolicySummary();
    	anna.should_see_transaction_history(userId,country,policyId,agreementNumber,txnFromDate,txnToDate,type,token);
//        anna.should_see_definition(definition);
    }

}
