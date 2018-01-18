package com.manulife.polaris.bdd.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.manulife.polaris.bdd.steps.serenity.PolarisUserSteps;

public class EditPercentageOfAllocationDefinitions {

	String userId;
	String country;
	String agreementComponentNum;
	String agreementNumber;
	String token;
	String productCode;
	String currentUser;
	
    @Steps
    PolarisUserSteps anna;
	private String fundCode2;
	private String fundCode1;
	private String fundCode3;
	private String fundCode4;
	private String fundName1;
	private String fundName2;
	private String fundName3;
	private String fundName4;
	private String percentAllocation1;
	private String percentAllocation2;
	private String percentAllocation3;
	private String percentAllocation4;

    
    //Scenario Outline: get my fund allocation list in My Fund Allocation page
    @Given("I have a list of funds in My fund allocation page")
    public void list_of_funds_in_My_fund_allocation_page() {
    }

    @When("I click edit/change fund allocation in Policy Summary page")
    public void click_edit_fund_allocation() {
    }
    
    @And("^my account with the data of user ID (.*), agreementComponentNum (.*), country code (.*), agreementNumber (.*) and token (.*)$")
    public void whenThePostfundallocationDatais(String userId, String agreementComponentNum, String country, String agreementNumber, String token) {
    	this.userId = userId;
    	this.agreementComponentNum = agreementComponentNum;
    	this.country = country;
    	this.agreementNumber = agreementNumber;
    	this.token = token;
    
    }

    @Then("I should see my fund allocation list.")
    public void i_should_see_my_fund_allocation_list() {
    	anna.should_see_my_fund_allocation_list(userId,agreementComponentNum,country,agreementNumber,token);
    }
    
    
    //Scenario Outline:get avaliable fund list in Additional Fund List page.
    @Given("I would like to add a fund to my fund allocation list")
    public void listoffunds() {
    }
    
    @When("I click add new funds button in My Fund Allocation page")
    public void when_i_click_add_new_funds_button() {
    }

    @And("^the data of my account with user ID (.*), agreementComponentNum (.*), country code (.*), agreementNumber (.*), productCode (.*) and token (.*)$")
    public void whenThePostavaliablefundDatais(String userId, String agreementComponentNum, String country, String agreementNumber, String productCode, String token) {
    	this.userId = userId;
    	this.agreementComponentNum = agreementComponentNum;
    	this.country = country;
    	this.agreementNumber = agreementNumber;
    	this.token = token;
    	this.productCode = productCode;
    }

    @Then("I should see the available fund list.")
    public void i_can_get_avaliable_list() {
    	anna.should_see_available_Fund_list(userId,agreementComponentNum,country,agreementNumber,productCode,token);
    }
    
    
    //Scenario Outline: submit and save the updated fund allocation.
   
    @Given("I confirm my updated fund allocation.")
    public void confirm_updated_fund_allocation1() {
    }
    
    @When("I click save button in My Fund Allocation page.")
    public void click_save_button() {
    }
    
    @And("^the updated fund post data should be user ID (.*), agreementComponentNum (.*), country code (.*), agreementNumber (.*), currentUser (.*)$")
    public void whenupdatefundDatais(String userId, String agreementComponentNum, String country, String agreementNumber, String currentUser) {
    	
    	this.userId = userId;
    	this.agreementComponentNum = agreementComponentNum;
    	this.country = country;
    	this.agreementNumber = agreementNumber;
    	this.currentUser = currentUser;
  
    }
    
    @And("^also the first fund details as (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void also_the_first_fund_details(String fundCode1, String fundName1, String percentAllocation1,String fundCode2, String fundName2, String percentAllocation2,String fundCode3, String fundName3, String percentAllocation3,String fundCode4, String fundName4, String percentAllocation4,String token) {
    	this.fundCode1 = fundCode1;
    	this.fundCode2 = fundCode2;
    	this.fundCode3 = fundCode3;
    	this.fundCode4 = fundCode4;
    	this.fundName1 = fundName1;
    	this.fundName2 = fundName2;
    	this.fundName3 = fundName3;
    	this.fundName4 = fundName4;
    	this.percentAllocation1 = percentAllocation1;
    	this.percentAllocation2 = percentAllocation2;
    	this.percentAllocation3 = percentAllocation3;
    	this.percentAllocation4 = percentAllocation4;
    	this.token = token;
    
    }

    @Then("I will go to the My Updated Fund Allocation Page and get my fund allocation list.")
    public void i_can_get_updated_avaliable_fund_list() {
    	anna.should_see_updated_allocation_list(userId,agreementComponentNum,country,agreementNumber,currentUser,fundCode1,fundCode2,fundCode3,fundCode4,fundName1,fundName2,fundName3,fundName4,percentAllocation1,percentAllocation2,percentAllocation3,percentAllocation4,token);
    }
    
    @Then("i will get the update failed")
    public void get_the_error() {
    	anna.should_get_the_error(userId,agreementComponentNum,country,agreementNumber,currentUser,fundCode1,fundCode2,fundCode3,fundCode4,fundName1,fundName2,fundName3,fundName4,percentAllocation1,percentAllocation2,percentAllocation3,percentAllocation4,token);
    }

}
