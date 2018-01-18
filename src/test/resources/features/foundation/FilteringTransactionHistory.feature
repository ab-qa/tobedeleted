@Sprint-4
@Story-POL-465
Feature: Filtering transaction history

 @Test-POL-1107 @Test-POL-1110 @Test-POL-1111 @Test-POL-1114 @Test-POL-1116 @Test-POL-1118 @Test-POL-1119 @Test-POL-1121
Scenario Outline: Filtering transaction history in Policy Summary 
Given I login the account with the user ID <userId>, policyID <policyId>, country code <country>, agreementNumber <agreementNumber> and token <token>
When I input the From date as <txnFromDate> and the To date as <txnToDate>
And select the account type as <type>
Then I should able to see my transaction history within <txnFromDate> and <txnToDate>

Examples:
| userId | country | policyId   | agreementNumber | txnFromDate              | txnToDate                | type | token |
| 0047   | PH      | 1709191495 | 11709191446     | 2016-01-01T00:00:00.000Z | 2017-12-01T00:00:00.000Z |  | token |
#| 0047   | PH      | 2812000047 | 0047           | 2016-01-01T00:00:00.000Z | 2017-01-01T00:00:00.000Z | DEPOSIT | token |
#| 0047   | PH      | 2812000047 | 0047           | 2016-01-01T00:00:00.000Z | 2017-01-01T00:00:00.000Z | PAY_PREMIUM | token |
#| 0047   | PH      | 1709191495 | 11709191446     | 2016-01-01T00:00:00.000Z | 2017-01-01T00:00:00.000Z | FEE_CHARGES | token |
#| 0305   | PH      | 1709191400 | 11709191446 | 2017-01-01T00:00:00.000Z | 2016-01-01T00:00:00.000Z |   | token |
#| 0305   | PH      | 1709191400 | 11709191446 | 2015-01-01T00:00:00.000Z | 2017-01-01T00:00:00.000Z |  | token |
#| 0305   | PH      | 1709191400 | 11709191446 | 2016-12-31T00:00:00.000Z | 2017-12-31T00:00:00.000Z |  | token |
#| 0305   | PH      | 1709191400 | 11709191446 | 2016-12-31T00:00:00.000Z | 2017-12-31T00:00:00.000Z |  | token |
