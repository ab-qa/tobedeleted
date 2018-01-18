@Story-POL-806 @Sprint4
Feature: Show policies Information on dashboard

@Test-POL-1075
Scenario Outline: Show policies Information on dashboard
Given I am succesfully login
When I login by the account with the user ID <userId>, country code <country>, policy ID <policyId>, agreementNumber <agreementNumber> and the policyname <policyName>
Then I can view policy information on dashboard

Examples:
| userId | country   | policyId   | agreementNumber | policyName |
| 11709191446 | PH   | 1709191495 | 11709191446   | MiWealth Assurance testing - 2812000047 |
#| 0305   | PH        | 1709191495 | 11709191446   | Manulife Affluence Builder |
