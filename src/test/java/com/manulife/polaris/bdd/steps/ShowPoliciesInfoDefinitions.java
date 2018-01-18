package com.manulife.polaris.bdd.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.manulife.polaris.bdd.steps.serenity.PolarisUserSteps;

public class ShowPoliciesInfoDefinitions {

	String userId;
	String country;
	String policyId;
	String agreementNumber;
	String policyName;
	
    @Steps
    PolarisUserSteps anna;

    @Given("I am succesfully login")
    public void givenTheUserIsOnTheSaleForceLoginPage() {
    }

    @When("^I login by the account with the user ID (.*), country code (.*), policy ID (.*), agreementNumber (.*) and the policyname (.*)$")
   public void i_login_by_the_account_with_the_user_ID_country_code_PH_policy_ID_agreementNumber_and_the_policyname_MiWealth_Assurance_testing(String userId, String country, String policyId, String agreementNumber, String policyName) {
    	this.userId = userId;
    	this.country = country;
    	this.policyId = policyId;
    	this.agreementNumber = agreementNumber;
    	this.policyName = policyName;
    }

    @Then("I can view policy information on dashboard")
    public void i_can_view_policies_infromation() {
		//    	anna.getPolicySummary();
    	anna.should_see_policy_infromation(userId,country,policyId,agreementNumber,policyName);
//        anna.should_see_definition(definition);
    }

}
