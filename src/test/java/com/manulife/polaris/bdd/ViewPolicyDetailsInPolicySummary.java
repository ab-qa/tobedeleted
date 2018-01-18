package com.manulife.polaris.bdd;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/consult_my_account/ViewPolicyDetailsInPolicySummary.feature")
public class ViewPolicyDetailsInPolicySummary {}
