package pages;

import gherkin.lexer.Th;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.Thread.sleep;

public class CustomerDepositPage {

    @FindBy(css = "button.btn-lg:nth-child(2)")
    WebElement depositTab;

    @FindBy(css = ".form-control")
    WebElement depositNumber;

    @FindBy(css = ".btn-default")
    WebElement depositButton;

    @FindBy(css = ".error")
    WebElement message;

    @FindBy(xpath = "//div[2]/strong[2]")
    WebElement accountBalance;

     int initialNumber = 0;
     static String time = "";

    CommonPage commonPage = new CommonPage();

    public void navigateToDepositTab() throws InterruptedException {
        Thread.sleep(2000);
        depositTab.click();
    }

    public void typeDepositAmount(String depositAmount) {
        initialNumber = getInitBalance();
        System.out.println(initialNumber+"khi submit");
        depositNumber.clear();
        depositNumber.sendKeys(depositAmount);
    }


    public void submitDeposit() {
        depositButton.click();
        time = getDateTime();
    }

    public int getInitBalance() {
        int balance = Integer.parseInt(accountBalance.getText());
        return balance;
    }

    public String getDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a");
        String formattedDate = myFormatObj.format(myDateObj);
        System.out.println(formattedDate +"laasy ko dc af");
        return formattedDate;
    }

    public String returnTime() {
        return time;
    }

    public void checkDepositStatus(String amountInput, boolean deposited) throws InterruptedException {
        String successText = "Deposit Successful";
        Thread.sleep(2000);
        int depositedAmount = Integer.parseInt(accountBalance.getText());
        int amount = 0;
        try {
            amount = Integer.parseInt(amountInput);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        System.out.println(initialNumber);
        if (message.isDisplayed()) {
            System.out.println(amount+" depo khi đưa vào");
            System.out.println(depositedAmount + "đã depo thành công");
            commonPage.verifyCondition(commonPage.verifyBalance(amount, initialNumber, depositedAmount), deposited);
            Thread.sleep(2000);
            Assert.assertEquals(message.getText(), successText);
        }
    }

}
