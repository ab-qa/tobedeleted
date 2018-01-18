package com.manulife.polaris.bdd.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.manulife.polaris.bdd.steps.serenity.PolarisUserSteps;

public class ViewPolicyDetailsInPolicySummaryDefinitions {

    @Steps
    PolarisUserSteps anna;

    @Given("I am on the Dashboard page")
    public void givenTheUserIsOnTheSaleForceLoginPage() {
    }

    @When("^my account with the user ID (.*), country code (.*), policy ID (.*), agreementNumber (.*) and policy name (.*)$")
    public void whenTheUserLoginWith(String userId, String country, String policyId, String agreementNumber, String policyName) {
    	anna.should_see_summary_infromation(userId,country,policyId,agreementNumber,policyName);
    }

    
 
    @Then("I can view Policy details section in Policy Summary")
    public void i_can_view_policies_infromation() {
//    	anna.getPolicySummary();
    	
//        anna.should_see_definition(definition);
    }

}
