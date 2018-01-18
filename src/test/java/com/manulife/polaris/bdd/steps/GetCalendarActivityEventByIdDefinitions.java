package com.manulife.polaris.bdd.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.manulife.polaris.bdd.steps.serenity.PolarisUserSteps;

public class GetCalendarActivityEventByIdDefinitions {

	String id;
	String country;
	
    @Steps
    PolarisUserSteps anna;

    @Given("I have a record in the calendar")
    public void select_the_record_by_id() {
    //this.id = id;
    }

    @When("^I select by the id (.*) and also the country code (.*)$")
    public void get_record_by_id(String id, String country) {
    	this.id = id;
    	this.country = country;
    }

    @Then("I should able to select the record")
    public void i_can_view_record_in_calendar() {
//    	anna.getPolicySummary();
    	anna.should_get_calendar_record_by_id(id, country);
//        anna.should_see_definition(definition);
    }
    
}
