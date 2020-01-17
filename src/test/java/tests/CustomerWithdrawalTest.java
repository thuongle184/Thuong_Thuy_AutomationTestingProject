package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static tests.PageProvider.*;

public class CustomerWithdrawalTest {

    @Given("^I click withdrawal tab$")
    public void openWithdrawalTab() throws Throwable {
        Thread.sleep(3000);
        getCustomerWithdrawalPage().getEfficiency();
        Thread.sleep(3000);
        getCustomerWithdrawalPage().navigateToWithdrawalTab();
    }

    @When("^I type withdrawal amount as (.*)$")
    public void chooseWithdrawalAmount(String withdrawalAmount) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerWithdrawalPage().typeWithdrawalAmount(withdrawalAmount);
    }

    @When("^I click withdrawal submit button$")
    public void clickWithdrawalSubmitButton() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerWithdrawalPage().submitWithdrawal();
        Thread.sleep(5000);
    }

    @Then("^I verify that customer withdrawal as (.*) successfully$")
    public void verifyWithdrawSuccessfully(String withdrawalAmount) throws InterruptedException {
        Thread.sleep(5000);
        String withdrawalTime = getCustomerWithdrawalPage().returnTime();
        getCustomerWithdrawalPage().checkWithdrawalStatus(withdrawalAmount, true);
        System.out.println(withdrawalTime +"thời gian with");
        Thread.sleep(5000);
        getTransactionHistoryPage().navigateTransactionTab();
        Thread.sleep(5000);
        getTransactionHistoryPage().checkTransaction(withdrawalTime, withdrawalAmount, "Withdrawal", true);
    }

    @Then("^I verify that customer withdrawal as (.*) unsuccessfully$")
    public void verifyWithdrawalUnsuccessfully(String withdrawalAmount) throws InterruptedException {
        Thread.sleep(3000);
        getCustomerWithdrawalPage().checkWithdrawalStatus(withdrawalAmount, false);
    }
}
