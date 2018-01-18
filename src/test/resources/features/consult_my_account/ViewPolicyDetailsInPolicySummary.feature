@Sprint4 @keep-alive
@Story-POL-772
Feature: View Policy details section in Policy Summary

@Test-POL-1072 @Test-POL-1074 @Test-POL-1078
Scenario Outline: View Policy details section in Policy Summary
Given I am on the Dashboard page
When my account with the user ID <userId>, country code <country>, policy ID <policyId>, agreementNumber <agreementNumber> and policy name <policyName>
Then I can view Policy details section in Policy Summary

Examples:
| userId | country   | policyId | agreementNumber | policyName |
| 11709191446 | PH   | 1709191495 | 11709191446   | MiWealth Assurance testing - 2812000047 |
#| 0305   | PH        | 2812000305 | 0305          | Manulife Affluence Builder |
