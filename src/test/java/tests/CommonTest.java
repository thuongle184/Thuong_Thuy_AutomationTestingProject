package tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runner.TestRunner;

import static java.lang.Thread.sleep;
import static tests.PageProvider.*;

public class CommonTest {

    @Given("Open website (.*)$")
    public void openTargetWebsite(String website) throws InterruptedException {
        TestRunner.driver.get(website);
        getCommonPage().checkPageUrl(website);
        TestRunner.driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Given("^I login successfully with username as (.*)$")
    public void loginBeforeAction(String loginUsername) throws InterruptedException {
        Thread.sleep(4000);
        getCustomerLoginPage().selectUserName(loginUsername);
        Thread.sleep(2000);
        getCustomerLoginPage().checkLoginButtonIsShown();
        getCustomerLoginPage().clickLoginButton();
        getCustomerLoginPage().verifyNavigateToDetailPage(loginUsername, true);
    }

    @Given("^I deposit successfully with deposit as (.*)$")
    public void alreadyDepositBeforeWithdrawal(String depositAmount) throws Throwable {
        Thread.sleep(3000);
        getCustomerDepositPage().navigateToDepositTab();
        Thread.sleep(2000);
        getCustomerDepositPage().typeDepositAmount(depositAmount);
        Thread.sleep(2000);
        getCustomerDepositPage().submitDeposit();
        sleep(4000);
        getCustomerDepositPage().checkDepositStatus(depositAmount, true);
        sleep(3000);
        String depositTime = getCustomerDepositPage().returnTime();
        getTransactionHistoryPage().navigateTransactionTab();
        sleep(3000);
        getTransactionHistoryPage().checkTransaction(depositTime, depositAmount, "Deposit", true);
        sleep(2000);
        getTransactionHistoryPage().clickButtonBack();
        sleep(1000);
    }
}
