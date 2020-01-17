# new feature
# Tags: optional

Feature: Customer Login

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/customer

  Scenario Outline: Customer Login Successfully
    When  I select username as <username>
    Then  I verify that user can see login button appears
    When  I click login button
    Then  I verify that user as <customer> login successfully

    Examples:
      | username         | customer         |
      | Ron Weasly       | Ron Weasly       |

  Scenario Outline: Customer Login Unsuccessfully
    When  I select username as <username>
    Then  I verify that user can not see login button appears and user login unsuccessfully

    Examples:
      | username        |
      | ---Your Name--- |
