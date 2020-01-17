# new feature
# Tags: optional

Feature: Customer Withdrawal

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
    And  I login successfully with username as Albus Dumbledore

  Scenario Outline: Customer Withdrawal Successfully
    When  I deposit successfully with deposit as 2000
    When  I click withdrawal tab
    When  I type withdrawal amount as <withdrawal>
    And   I click withdrawal submit button
    Then  I verify that customer withdrawal as <withdrawal> successfully

    Examples:
      | withdrawal |
      | 1000       |

  Scenario Outline: Customer Withdrawal Unsuccessfully  with the Amount Requested is Bigger than Balance
    When I click withdrawal tab
    When I type withdrawal amount as <withdrawal>
    And  I click withdrawal submit button
    Then I verify that customer withdrawal as <withdrawal> unsuccessfully

    Examples:
      | withdrawal |
      | 7000       |