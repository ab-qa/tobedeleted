package com.manulife.polaris.bdd.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.manulife.polaris.bdd.steps.serenity.PolarisUserSteps;

public class WithdrawFromPremiumInAmountDefinitions {

	String userId;
	String country;
	String policyId;
	String agreementNumber;
	String policyName;
	
	private  Float chargesAmount;
	private  Float netAmount;
	private  Float withdrawAmount;
	
	
    @Steps
    PolarisUserSteps anna;
	private String token;
	private String amount;
	private String currencyCode;
	private String isFullSurrender;
	private String valueType;
	private String txnType;
	private String bankAccountName;
	private String bankAccountNum;
	private String currentUser;

	
    @Given("I already login and have sufficient amount in my premium account")
    public void havesufficientamountinmypremiumaccount() {
    }

    @When("I deposit/withdraw button in Policy Summary page.")
    public void withdrawbuttoninPolicySummarypage(){
    }
    
    @And("^the post data to the deposit/withdraw page should be userId (.*), policyId (.*), country code (.*), agreementNumber (.*), policyName (.*) and token (.*)$")
    public void whenThePostfundallocationDatais(String userId, String policyId, String country, String agreementNumber,String policyName, String token) {
    	this.userId = userId;
    	this.policyId = policyId;
    	this.country = country;
    	this.agreementNumber = agreementNumber;
    	this.policyName = policyName;
    	this.token = token;
    
    }

    @Then("I will get my balance in deposit/withdraw page.")
    public void i_can_view_policies_infromation() {
    	anna.get_my_balance_in_deposit(userId,policyId,country,agreementNumber,policyName,token);
    }
    
    
    
    @Given("I withdraw the amount bigger than the minimum withdraw amount and smaller than the current value.")
    public void withdrawtheamount() {
    }

    @When("^I input (.*) dollar$")
    public void inputamount(String amount){
    	this.amount =amount;
    }
    
    @And("^the post data to the preview page should be userId (.*), policyId (.*), country code (.*), agreementNumber (.*), currencyCode (.*), is that surrender (.*), token (.*), withdraw or deposit (.*) and withdraw by amount or percentage (.*)$")
    public void postdatatothedepositDatais(String userId, String policyId, String country,String agreementNumber,String currencyCode,String isFullSurrender,String token,String txnType, String valueType) {
    	this.userId = userId;
    	this.policyId = policyId;
    	this.country = country;
    	this.agreementNumber = agreementNumber;
    	this.currencyCode = currencyCode;
    	this.isFullSurrender = isFullSurrender;
    	this.token = token;
    	this.txnType = txnType;
    	this.valueType = valueType;
    	
    }


    @Then("the preview page will display the withdraw amount with the breakdown, the examples result: chargesAmount: (.*), netAmount: (.*), withdrawAmount: (.*), minBalance (.*)$")
    public void thewithdrawamountwiththebreakdown(Float chargesAmount,Float netAmount,Float withdrawAmount,Float minBalance) {

    	this.chargesAmount = chargesAmount;
    	this.netAmount = netAmount;
    	this.withdrawAmount = withdrawAmount;	anna.should_see_the_amount_breakdown(userId,policyId,country,amount,agreementNumber,currencyCode,isFullSurrender,token,txnType,valueType,chargesAmount,netAmount,withdrawAmount,minBalance);
    	
    	
    }
    
    
   //confirm and submit the withdraw amount

@Given("^I confirm the withdrawAmount$")
public void i_confirm_the_withdrawAmount() throws Throwable {

}

@When("^I click confirm button in the Preview page\\.$")
public void i_click_confirm_button_in_the_Preview_page() throws Throwable {

}



@And("the validate the withdraw amountexamples result: chargesAmount: (.*), netAmount: (.*), withdrawAmount: (.*), minBalance (.*)$")
public void thewithdrawamount(Float chargesAmount,Float netAmount,Float withdrawAmount,Float minBalance) {
	this.chargesAmount = chargesAmount;
	this.netAmount = netAmount;
	this.withdrawAmount = withdrawAmount;
	
}


@And("^the post data to submit should be userId (.*), policyId (.*), country code (.*), agreementNumber (.*), bankAccountName (.*), bankAccountNum (.*), currencyCode (.*), currentUser (.*), is that surrender\\? (.*), token (.*), withdraw or deposit\\? (.*) and withdraw by amount or percentage\\? (.*)$")
public void the_post_data_to_submit_should_be_userId_policyId_country_code_PH_agreementNumber_bankAccountName_bankAccountName_bankAccountNum_bankAccountNum_currencyCode_PHP_is_that_surrender_N_token_token_withdraw_or_deposit_withdraw_and_withdraw_by_amount_or_percentage_amount(String userId, String policyId, String country,String agreementNumber,String bankAccountName,String bankAccountNum,String currencyCode,String currentUser,String isFullSurrender,String token,String txnType,String valueType){
	this.userId = userId;
	this.policyId = policyId;
	this.country = country;
	this.bankAccountName = bankAccountName;
	this.bankAccountNum = bankAccountNum;
	this.agreementNumber = agreementNumber;
	this.currencyCode = currencyCode;
	this.currentUser =currentUser;
	this.isFullSurrender = isFullSurrender;
	this.token = token;
	this.txnType = txnType;
	this.valueType = valueType;
}



@Then("^the preview page will display the withdraw amount with the breakdown\\.$")
public void the_preview_page_will_display_the_withdraw_amount_with_the_breakdown() {
	anna.should_see_the_withdraw_amount_breakdown(userId,policyId,country,agreementNumber,bankAccountName,bankAccountNum,currencyCode,currentUser,isFullSurrender,token,txnType,valueType,chargesAmount,netAmount,withdrawAmount);
}

    

}
