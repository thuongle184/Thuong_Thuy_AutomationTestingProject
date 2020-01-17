# Created by nththuy at 1/3/20
Feature: Open Account
  In order to open account, I want to have the adding customer feature so that I can add customer easily

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/manager/openAccount

  Scenario Outline:  Open Account sucessfully
    When I choose account as <fullname> and currency as <currency>
    And I click open account
    Then I verify that user account as <useraccount> and post code as <postcode>  is already opened
    Examples:
      | fullname         | currency | useraccount      | postcode |
      | Harry Potter     | Pound    | Harry Potter     | E725JB   |

  Scenario Outline:  Open Account unsucessfully with null user name
    When I choose account as <fullname> and currency as <currency>
    And I click open account
    Then I verify that user account as <user> and post code as <postcode>  is not opened
    Examples:
      | fullname            | currency       | user                | postcode |
      | ---Customer Name--- | Pound          | ---Customer Name--- | E725JB   |