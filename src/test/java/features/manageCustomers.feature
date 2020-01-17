# new feature
# Tags: optional

Feature: Manage Customers' Accounts

  Background:
    Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager/list

  Scenario Outline: Manage Customers' Accounts Successfully
    When I type value as <searchvalue> on search box
    Then I verify that result of value as <searchInput> is visable on the table
    When I click on title as <sortedcollum> to sort
    Then I verify that user account at collumn as <collumnindex> sorted successfully
    When I click delete button at user account as <useraccountname> post code as <code> account number as <accountnumber>
    Then I verify that manager can delete user account as <accountname> and post code as <postcode> account number as <deletedaccountnumber> successfully

    Examples:
      | useraccountname  | code   | accountnumber | accountname      | postcode | deletedaccountnumber | searchvalue | searchInput | sortedcollum | collumnindex |
      | Hermoine Granger | E859AB | 1003          | Hermoine Granger | E859AB   | 1003                 | v           | v           | Last Name    | 2            |

  Scenario Outline: Search Customers' Accounts Unsuccessfully
    When I type value as <searchvalue> on search box
    Then I verify that results of value as <searchInput> is wrong or nothing change

    Examples:
      | searchvalue | searchInput |
      | t           | t           |