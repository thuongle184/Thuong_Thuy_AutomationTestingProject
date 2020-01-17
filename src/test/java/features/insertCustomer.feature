Feature: Add Customer
  In order to store user information, I want to have the adding customer feature so that I can add customer easily

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust

  Scenario Outline: Add Customer sucessfully
    When I type first name as <firstname>, last name as <lastname>, post code as <postcode>
    And I click submit
    Then I verify that system is already added customer as <fullname> successfully
    Examples:
      | firstname | lastname | postcode | fullname    |
      | thuy      | nguyen   | 55000    | thuy nguyen |

  Scenario Outline: Add Customer unsucessfully
    When I type first name as <firstname>, last name as <lastname>, post code as <postcode>
    And I click submit
    Then I verify that system is already added customer as <fullname> unsuccessfully
    Examples:
      | firstname | lastname | postcode | fullname |
      | thuy      | null     | 55000    | thuy     |
