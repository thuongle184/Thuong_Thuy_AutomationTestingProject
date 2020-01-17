package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.lang.Thread.sleep;
import static tests.PageProvider.*;

public class CustomerDepositTest {

    @When("^I click deposit tab$")
    public void clickDepositTab() throws InterruptedException {
        Thread.sleep(3000);
        getCustomerDepositPage().navigateToDepositTab();
    }

    @When("^I type the deposit amount as (.*)$")
    public void chooseDepositAmount(String depositAmount) throws InterruptedException {
        sleep(2000);
        getCustomerDepositPage().typeDepositAmount(depositAmount);
    }

    @When("^I click deposit submit button$")
    public void clickDepositSubmitButton() throws InterruptedException {
        sleep(2000);
        getCustomerDepositPage().submitDeposit();
    }

    @Then("^I verify that customer deposit as (.*) successfully$")
    public void depositSuccessfully(String deposit) throws InterruptedException {
        sleep(2000);
        getCustomerDepositPage().checkDepositStatus(deposit, true);
        sleep(4000);
        String depositTime = getCustomerDepositPage().returnTime();
        sleep(3000);
        System.out.println(depositTime+"mo roi");
        getTransactionHistoryPage().navigateTransactionTab();
        sleep(3000);
        getTransactionHistoryPage().checkTransaction(depositTime, deposit, "Deposit", true);
        sleep(3000);
    }

    @Then("^I verify that customer deposit as (.*) unsuccessfully$")
    public void verifyDepositUnsuccessfully(String amountMoney) throws InterruptedException {
        sleep(3000);
        getCustomerDepositPage().checkDepositStatus(amountMoney, false);
        sleep(2000);

    }

}
