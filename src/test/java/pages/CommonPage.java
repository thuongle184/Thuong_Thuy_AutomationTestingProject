package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import runner.TestRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CommonPage {

    public String getAndCloseAlertPopup() throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
        alert.accept();
        return alertMessage;
    }

    public void checkPageUrl(String webUrl) throws InterruptedException {
        String URL = TestRunner.driver.getCurrentUrl();
        Assert.assertEquals(URL, webUrl);
        Thread.sleep(2000);
    }

    public String getAccountNumber() throws InterruptedException {
        Thread.sleep(2000);
        String alertText = getAndCloseAlertPopup();
        Thread.sleep(2000);
        String accountNumber = "";
        for (int i = 0; i < alertText.length(); i++) {
            Boolean isDigit = Character.isDigit(alertText.charAt(i));
            if (isDigit) {
                accountNumber += alertText.charAt(i);
            }
        }
        System.out.println(accountNumber);
        return accountNumber;
    }

    public void verifyCondition(boolean actually, boolean expected) {
        if (!actually) {
            if (expected) Assert.assertEquals(1, 0);
        } else {
            if (!expected) Assert.assertEquals(1, 0);
        }
    }

    public boolean verifyBalance(int amount, int initialNumber, int targetAmount) {
        System.out.println(amount+ initialNumber+targetAmount + "tong tien con lai");
        System.out.println(amount+"thoi");
        boolean success = false;
        int balanceNum = 0;

        if (!(amount == 0)) {
            balanceNum = initialNumber + amount;
        }

        if (targetAmount == balanceNum) {
            success = true;
        }
        return success;
    }

}
