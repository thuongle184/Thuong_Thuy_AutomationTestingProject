package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import static tests.PageProvider.getManageCustomerAccountPage;

public class ManageCustomerAccountTest {

    @When("^I type value as (.*) on search box$")
    public void verifySearchBox(String searchValueInput) throws InterruptedException {
        getManageCustomerAccountPage().setSearchValue(searchValueInput);
    }

    @Then("^I verify that result of value as (.*) is visable on the table$")
    public void verifySearchSuccessfully(String valueSearch) throws InterruptedException {
        getManageCustomerAccountPage().checkSearchSuccessfully(valueSearch, true);
    }

    @When("^I click on title as (.*) to sort$")
    public void setSortedCollum(String sortedCollum) throws InterruptedException {
        getManageCustomerAccountPage().setColumnSort(sortedCollum);
    }

    @Then("^I verify that user account at collumn as (.*) sorted successfully$")
    public void verifySortSuccessfully(int index) throws InterruptedException {
        getManageCustomerAccountPage().verifySortResult(true, index);
    }

    @When("^I click delete button at user account as (.*) post code as (.*) account number as (.*)$")
    public void clickDeleteAccount(String accountNameInput, String postcodeInput, String accountNumberInput) throws Throwable {
        getManageCustomerAccountPage().deleteCustomerAccount(accountNameInput, postcodeInput, accountNumberInput);
    }

    @Then("^I verify that manager can delete user account as (.*) and post code as (.*) account number as (.*) successfully$")
    public void deleteSuccessfully(String accountNameInput, String postCode, String accountNumberInput) throws InterruptedException {
        getManageCustomerAccountPage().checkAccountExisted(accountNameInput, postCode, accountNumberInput, false);
    }

}
