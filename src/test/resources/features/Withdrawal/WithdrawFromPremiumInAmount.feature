@Sprint2 @Sprint3 @Sprint6 
@Story-POL-637 @Story-POL-710 @Story-POL-253 @Story-POL-254 @Story-POL-258
Feature: withdraw from premium in $ amount

@Test-POL-1092 @Test-POL-1094 @Test-POL-1096 @Test-POL-1105
Scenario Outline: get current balance in deposit/withdraw page
Given I already login and have sufficient amount in my premium account
When I deposit/withdraw button in Policy Summary page.
And the post data to the deposit/withdraw page should be userId <userId>, policyId <policyId>, country code <country>, agreementNumber <agreementNumber>, policyName <policyName> and token <token> 
Then I will get my balance in deposit/withdraw page.

Examples:
| userId | policyId | country  | agreementNumber | policyName | token |
| 0047   |1709191495| PH       | 11709191446     | MiWealth Assurance testing - 2812000047 | token |
#| 0305  |2812000305| PH       | 0305            | Manulife Affluence Builder | token |

@Test-POL-1092 @Test-POL-1094 @Test-POL-1096 @Test-POL-1105
Scenario Outline: validate and confirm the withdraw amount
Given I withdraw the amount bigger than the minimum withdraw amount and smaller than the current value.
When I input <amount> dollar 
And the post data to the preview page should be userId <userId>, policyId <policyId>, country code <country>, agreementNumber <agreementNumber>, currencyCode <currencyCode>, is that surrender <isFullSurrender>, token <token>, withdraw or deposit <txnType> and withdraw by amount or percentage <valueType> 
Then the preview page will display the withdraw amount with the breakdown, the examples result: chargesAmount: <chargesAmount>, netAmount: <netAmount>, withdrawAmount: <withdrawAmount>, minBalance <minBalance>
And the post data to submit should be userId <userId>, policyId <policyId>, country code <country>, agreementNumber <agreementNumber>, bankAccountName <bankAccountName>, bankAccountNum <bankAccountNum>, currencyCode <currencyCode>, currentUser <currentUser>, is that surrender? <isFullSurrender>, token <token>, withdraw or deposit? <txnType> and withdraw by amount or percentage? <valueType> 
Then the preview page will display the withdraw amount with the breakdown. 

Examples:
| userId | policyId | country | amount | agreementNumber | currencyCode | currentUser 	        |isFullSurrender | token | txnType | valueType | chargesAmount | netAmount | withdrawAmount |  minBalance | bankAccountName | bankAccountNum   |
| 0047 | 1709191495 | PH      | 10000    | 11709191446    | PHP   		|   0050k000000GHzOAAW  | N               | token | withdraw| amount  | 7000  |  3000  |  10000  | 10000 | bankAccountName | bankAccountNum  |
#| 0305 | 2812000305 | PH      | 10000  | 0305            | SGD    		 |   0050k000000GHzOAAW          | N               | token | withdraw| amount    |  0.0f  |  10000.0f  |  10000.0f  | 20000.0f | bankAccountName | bankAccountNum  |
