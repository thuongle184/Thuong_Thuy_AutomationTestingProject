package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static tests.PageProvider.getLoginOptionPage;

public class LoginOptionTest {

    @When("^I click customer login button$")
    public void clickCustomerLogin() throws Throwable {
        getLoginOptionPage().pressCustomerLoginButton();
    }

    @Then("^I verify system navigates to customer login page$")
    public void verifyCustomerLoginPage() throws InterruptedException {
        getLoginOptionPage().showCheckCustomerLoginPageResult(true);
    }

    @When("^I click bank manager login button$")
    public void clickManagerLogin() throws Throwable {
        getLoginOptionPage().pressManagerLoginButton();
    }

    @Then("^I verify system navigates to manager login page$")
    public void verifyManagerLoginPage() throws InterruptedException {
        getLoginOptionPage().showCheckManagerLoginPageResult(true);
    }

}