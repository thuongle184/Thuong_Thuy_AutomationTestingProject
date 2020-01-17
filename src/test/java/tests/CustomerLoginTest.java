package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static tests.PageProvider.getCustomerLoginPage;

public class CustomerLoginTest {

    @When("^I select username as (.*)$")
    public void selectUserName(String usernameSelected) throws InterruptedException {
        Thread.sleep(3000);
        getCustomerLoginPage().selectUserName(usernameSelected);
    }

    @Then("^I verify that user can see login button appears$")
    public void verifyUsernameSelected() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerLoginPage().verifyUserCanClickLogin(true);
    }

    @When("^I click login button$")
    public void clickLogin() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerLoginPage().clickLoginButton();
    }

    @Then("^I verify that user as (.*) login successfully$")
    public void verifyLoginSuccessfully(String customer) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerLoginPage().verifyNavigateToDetailPage(customer, true);
    }

    @Then("^I verify that user can not see login button appears and user login unsuccessfully$")
    public void verifyButtonNotAppear() throws InterruptedException {
        Thread.sleep(3000);
        getCustomerLoginPage().buttonNotAppear(false);
    }

}
