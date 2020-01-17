# new feature
# Tags: optional

Feature: Login Options

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

  Scenario: Customer chooses customer login option successfully
    When I click customer login button
    Then I verify system navigates to customer login page

  Scenario: Customer chooses bank manager login option successfully
    When I click bank manager login button
    Then I verify system navigates to manager login page