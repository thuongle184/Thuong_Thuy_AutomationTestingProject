# new feature
# Tags: optional

Feature: Customer Deposit

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/customer
    And I login successfully with username as Ron Weasly
    And I click deposit tab

  Scenario Outline: Customer Deposit Successfully
    When I type the deposit amount as <deposit>
    And I click deposit submit button
    Then I verify that customer deposit as <depositAmount> successfully

    Examples:
      | deposit | depositAmount |
      | 2000    | 2000          |

  Scenario Outline: Customer Deposit Unsuccessfully
    When I type the deposit amount as <deposit>
    And I click deposit submit button
    Then I verify that customer deposit as <deposit> unsuccessfully

    Examples:
      | deposit |
      |         |