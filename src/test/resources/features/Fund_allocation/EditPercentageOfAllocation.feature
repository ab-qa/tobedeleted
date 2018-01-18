@Story-POL-803 @Story-POL-763 @Sprint4
Feature: edit percentage of allocation in My fund allocation page

@Test-POL-1079 @Test-POL-1085 @Test-POL-1087 @Test-POL-1089 @Test-POL-1090 @Test-POL-1091 @Test-POL-1093 @Test-POL-1080 @Test-POL-1081
Scenario Outline: get my fund allocation list in My Fund Allocation page
Given I have a list of funds in My fund allocation page
When I click edit/change fund allocation in Policy Summary page
And my account with the data of user ID <userId>, agreementComponentNum <agreementComponentNum>, country code <country>, agreementNumber <agreementNumber> and token <token> 
Then I should see my fund allocation list.

Examples:
| userId |agreementComponentNum | country  | agreementNumber | token |
| 0047   |1709191495            | PH       | 11709191446            | token |
#| 0305   |2812000305            | PH       | 0305            | token |


@Test-POL-1083
Scenario Outline: get avaliable fund list in Additional Fund List page
Given I would like to add a fund to my fund allocation list
When I click add new funds button in My Fund Allocation page
And the data of my account with user ID <userId>, agreementComponentNum <agreementComponentNum>, country code <country>, agreementNumber <agreementNumber>, productCode <productCode> and token <token>
Then I should see the available fund list. 

Examples:
| userId |agreementComponentNum | country  | agreementNumber | productCode | token |
| 0047   |1709191495            | PH       | 11709191446     | UL0001      | token |
#| 0305   |2812000305            | PH       | 0305            | UL0001      | token |
#| 0305   |2812000311            | PH       | 0305            | UL0001      | token |

@Test-POL-1079 @Test-POL-1090
Scenario Outline: submit and save the updated fund allocation.
Given I confirm my updated fund allocation.
When I click save button in My Fund Allocation page.
And the updated fund post data should be user ID <userId>, agreementComponentNum <agreementComponentNum>, country code <country>, agreementNumber <agreementNumber>, currentUser <currentUser>
And also the first fund details as <fundCode1>, <fundName1>, <percentAllocation1>, <fundCode2>, <fundName2>, <percentAllocation2>, <fundCode3>, <fundName3>, <percentAllocation3>, <fundCode4>, <fundName4>, <percentAllocation4> and <token>  
Then I will go to the My Updated Fund Allocation Page and get my fund allocation list.

Examples:
| userId |agreementComponentNum | country  | agreementNumber | currentUser | fundCode1 | fundCode2 |  fundCode3 |  fundCode4 |  fundName1 | fundName2 | fundName3 | fundName4 | percentAllocation1 | percentAllocation2 | percentAllocation3 | percentAllocation4 | token |
| 0047   |1709191495            | PH       | 11709191446     | UL0001      | MANLIEQ   | MANEMLC   | MANESMC    | MANOFFSH   | Manulife SG Equity Fund | Manulife SG Equity Mid Large Capital | Manulife Dana Ekuitas Small Mid Capital | Manulife SG Offshore Funds | 100 | 0 | 1 | 9 | token |
#| 0047   |2812000047            | PH       | 0047            | UL0002      | MANLIEQ   | MANEMLC   | MANESMC    | MANOFFSH   | Manulife SG Equity Fund | Manulife SG Equity Mid Large Capital | Manulife Dana Ekuitas Small Mid Capital | Manulife SG Offshore Funds | 100 | 50 | 20 | 99 | token |

@Test-POL-1085 @Test-POL-1087 @Test-POL-1089 @Test-POL-1091 @Test-POL-1093
Scenario Outline: submit and save the updated fund allocation(fund > 100%) or (fund < 100%).
Given I confirm my updated fund allocation.
When I click save button in My Fund Allocation page.
And the updated fund post data should be user ID <userId>, agreementComponentNum <agreementComponentNum>, country code <country>, agreementNumber <agreementNumber>, currentUser <currentUser>
And also the first fund details as <fundCode1>, <fundName1>, <percentAllocation1>, <fundCode2>, <fundName2>, <percentAllocation2>, <fundCode3>, <fundName3>, <percentAllocation3>, <fundCode4>, <fundName4>, <percentAllocation4> and <token>    
Then i will get the update failed

Examples:
| userId |agreementComponentNum | country  | agreementNumber | currentUser | fundCode1 | fundCode2 |  fundCode3 |  fundCode4 |  fundName1 | fundName2 | fundName3 | fundName4 | percentAllocation1 | percentAllocation2 | percentAllocation3 | percentAllocation4 | token |
| 0047   |1709191495            | PH       | 11709191446     | UL0001      | MANLIEQ   | MANEMLC   | MANESMC    | MANOFFSH   | Manulife SG Equity Fund | Manulife SG Equity Mid Large Capital | Manulife Dana Ekuitas Small Mid Capital | Manulife SG Offshore Funds | 0 | 0 | 1 | 9 | token |
#| 0047   |2812000047            | PH       | 0047            | UL0002      | MANLIEQ   | MANEMLC   | MANESMC    | MANOFFSH   | Manulife SG Equity Fund | Manulife SG Equity Mid Large Capital | Manulife Dana Ekuitas Small Mid Capital | Manulife SG Offshore Funds | 120 | 50 | 20 | 99 | token |

