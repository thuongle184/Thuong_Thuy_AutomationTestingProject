package tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static tests.PageProvider.*;

public class TransactionHistoryTest {

    int balance = 0;

    @When("^I withdrawal successfully with withdrawal as (.*)$")
    public void setWithdrawal(String withdrawalAmount) throws Throwable {
        getCustomerWithdrawalPage().navigateToWithdrawalTab();
        Thread.sleep(2000);
        getCustomerWithdrawalPage().typeWithdrawalAmount(withdrawalAmount);
        Thread.sleep(2000);
        getCustomerWithdrawalPage().submitWithdrawal();
        getCustomerWithdrawalPage().checkWithdrawalStatus(withdrawalAmount, true);

    }

    @When("^I click transaction tab$")
    public void clickTransactionTab() throws Throwable {
        balance = getCustomerWithdrawalPage().getBalanceAccount();
        Thread.sleep(3000);
        getTransactionHistoryPage().navigateTransactionTab();
    }

    @Then("^I verify the data at transaction is correct$")
    public void verifyDataCorrect() throws Throwable {
        Thread.sleep(1000);
        getTransactionHistoryPage().balanceEqualTransaction(balance, true);

    }

    @When("^I click reset button$")
    public void clickResetButton() throws Throwable {
        Thread.sleep(5000);
        getTransactionHistoryPage().clickButtonReset();
    }

    @Then("^I verify the transaction table is empty$")
    public void verifyDataReseted() throws Throwable {
        getTransactionHistoryPage().checkEmptyTable(true);
        Thread.sleep(3000);
    }

    @When("^I click back button$")
    public void clickBackButton() throws Throwable {
        Thread.sleep(2000);
        getTransactionHistoryPage().clickButtonBack();
    }

    @Then("^I verify page transaction backed$")
    public void verifyPageBack() throws Throwable {
        getTransactionHistoryPage().verifyBackButtonDoCorrectly(true);
        Thread.sleep(2000);
    }

}
