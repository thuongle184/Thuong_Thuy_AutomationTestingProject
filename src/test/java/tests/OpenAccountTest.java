package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenAccountTest extends PageProvider {

    @When("^I choose account as (.+) and currency as (.+)$")
    public void openAccount(String fullname, String currency) throws InterruptedException {
        Thread.sleep(2000);
        getOpenAccountPage().getUserName(fullname);
        getOpenAccountPage().getCurrency(currency);
    }

    @And("^I click open account$")
    public void clickOpenAccount() throws InterruptedException {
        getOpenAccountPage().clickProcess();
    }

    @Then("^I verify that user account as (.*) and post code as (.*) is already opened$")
    public void verifyUserAlreadyOpen(String userFullName, String postCode) throws InterruptedException {
        String accountNumber = getCommonPage().getAccountNumber();
        getManageCustomerAccountPage().clickCustomerTab();
        Thread.sleep(1000);
        getManageCustomerAccountPage().checkAccountExisted(userFullName, postCode, accountNumber, true);
    }

    @Then("^I verify that user account as (.*) and post code as (.*)  is not opened$")
    public void verifyCustomerOpenUnSuccessfully(String fullname, String postcode) throws InterruptedException {
        Thread.sleep(3000);
        getManageCustomerAccountPage().clickCustomerTab();
        getManageCustomerAccountPage().checkAccountExisted(fullname, postcode, "1000", false);
    }

}
