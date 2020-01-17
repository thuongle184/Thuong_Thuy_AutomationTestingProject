package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InsertCustomerTest extends PageProvider {

    @When("^I type first name as (.+), last name as (.+), post code as (.+)$")
    public void inputUserInformation(String firstname, String lastname, String postcode) throws InterruptedException {
        getInsertCustomerPage().setUserInformation(firstname, lastname, postcode);
    }

    @And("^I click submit$")
    public void clickSubmit() throws InterruptedException {
        getInsertCustomerPage().clickSubmit();
    }

    @Then("^I verify that system is already added customer as (.+) successfully$")
    public void verifyCustomerAddSuccessfully(String fullname) throws InterruptedException {
        getCommonPage().getAndCloseAlertPopup();
        Thread.sleep(1000);
        getOpenAccountPage().clickOpenAccountTab();
        Thread.sleep(1000);
        getOpenAccountPage().checkUserInformation(fullname, true);
    }

    @Then("^I verify that system is already added customer as (.+) unsuccessfully")
    public void verifyCustomerAddUnSuccessfully(String fullname) throws InterruptedException {
        getOpenAccountPage().clickOpenAccountTab();
        Thread.sleep(1000);
        getOpenAccountPage().checkUserInformation(fullname, false);
    }

}
