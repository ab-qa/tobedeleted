@Sprint5 
@Story-POL-1182
Feature: Get calendar activity event by Id

@Test-POL-1374
Scenario Outline: Get calendar activity event by Id
Given I have a record in the calendar
When I select by the id <id> and also the country code <country>
Then I should able to select the record

Examples:
| id | country |
| 13 |  PH    |
