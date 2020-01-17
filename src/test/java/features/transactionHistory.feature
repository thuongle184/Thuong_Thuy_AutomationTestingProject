# new feature
# Tags: optional

Feature: Customer Transaction History

  Background:
    Given Open website http://www.way2automation.com/angularjs-protractor/banking/#/customer
    And I login successfully with username as Harry Potter

  Scenario Outline: Customer View Transaction History Successfully
    When I deposit successfully with deposit as <deposit>
    And  I withdrawal successfully with withdrawal as <withdrawal>
    And  I click transaction tab
    Then I verify the data at transaction is correct

    Examples:
      | deposit | withdrawal |
      | 2000    | 1000       |

  Scenario: Customer Reset Transaction History Successfully
    When I click transaction tab
    When I click reset button
    Then I verify the transaction table is empty
    When I click back button
    Then I verify page transaction backed
