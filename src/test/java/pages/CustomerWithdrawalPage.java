package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerWithdrawalPage {

    @FindBy(css = "button.btn-lg:nth-child(3)")
    WebElement withdrawlTab;

    @FindBy(css = ".form-control")
    WebElement withdrawlNumber;

    @FindBy(css = ".btn-default")
    WebElement withdrawlButton;

    @FindBy(css = ".error")
    WebElement message;

    @FindBy(css = "strong.ng-binding:nth-child(2)")
    WebElement balanceAccount;

    static int initialAccount = 0;
    static String time = "";

    CommonPage commonPage = new CommonPage();

    public void navigateToWithdrawalTab() {
        this.withdrawlTab.click();
        initialAccount = getEfficiency();
    }

    public void typeWithdrawalAmount(String withdrawalAmount) {
        initialAccount = getInitBalance();
        this.withdrawlNumber.clear();
        this.withdrawlNumber.sendKeys(withdrawalAmount);
    }

    public void submitWithdrawal() throws InterruptedException {
        Thread.sleep(3000);
        withdrawlButton.click();
        time = getDateTime();

    }

    public int getInitBalance() {
        int balance = Integer.parseInt(balanceAccount.getText());
        return balance;
    }


    public static int getEfficiency (){
        int temp=initialAccount;
        initialAccount=0;
        return temp;
    }

    public String getDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a");
        String formattedDate = myFormatObj.format(myDateObj);
        return formattedDate;
    }

    public String returnTime() {
        return time;
    }

    public void checkWithdrawalStatus(String amountInput, boolean withdrawal) throws InterruptedException {
        Thread.sleep(2000);
        int amount = 0, edAmount = 0;
        try {
            amount = Integer.parseInt(amountInput);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
        System.out.println(amountInput+"with lấy ra");
        edAmount = -amount;
        System.out.println(edAmount+ "đúng nì");

        int withDrawlAmount = Integer.parseInt(balanceAccount.getText());

        System.out.println(initialAccount+"with ban đầu");
        System.out.println(withDrawlAmount+" balance mới lấy ra");

        Thread.sleep(2000);
        if (message.isDisplayed()) {
            Thread.sleep(1000);
            commonPage.verifyCondition(commonPage.verifyBalance(edAmount, initialAccount, withDrawlAmount), withdrawal);
        }
    }

    public Integer getBalanceAccount() {
        return Integer.parseInt(balanceAccount.getText());

    }
}
