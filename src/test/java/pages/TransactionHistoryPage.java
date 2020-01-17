package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TransactionHistoryPage {

    @FindBy(xpath = "//div[2]/table")
    WebElement transactionTable;

    @FindBy(css = "button.btn-lg:nth-child(1)")
    WebElement transactionTab;

    @FindBy(xpath = "//div[2]/div/div[1]/button[1]")
    WebElement backButton;

    @FindBy(xpath = "//div[2]/div/div[1]/button[2]")
    WebElement resetButton;

    @FindBy(css = ".fontBig")
    WebElement welcomeName;

    CommonPage commonPage = new CommonPage();

    public void navigateTransactionTab() throws InterruptedException {
        transactionTab.click();
        Thread.sleep(2000);
    }

    public void clickButtonReset() throws InterruptedException {
        Thread.sleep(2000);
        resetButton.click();
    }

    public void verifyBackButtonDoCorrectly(boolean backed) throws InterruptedException {
        boolean isBacked = false;

        if (transactionTab.isDisplayed() && welcomeName.isDisplayed()) {
            Thread.sleep(2000);
            isBacked = true;
        }
        commonPage.verifyCondition(backed, isBacked);
    }

    public void clickButtonBack() {
        backButton.click();
    }

    public void checkEmptyTable(boolean isEmpty) {
        boolean empty;
        List<WebElement> listTr = transactionTable.findElements(By.tagName("tr"));
        if (listTr.size() > 1) {
            empty = false;
        } else {
            empty = true;
        }
        commonPage.verifyCondition(empty, isEmpty);
    }

    public boolean checkTransactionHistory(String dateTime, String amountInput, String typeOfTransaction) throws InterruptedException {

        int transacted = 0;
        List<WebElement> listTransaction = transactionTable.findElements(By.tagName("tr"));
        Thread.sleep(1000);

        for (int i = 1; i < listTransaction.size(); i++) {

            List<WebElement> listTd = listTransaction.get(i).findElements(By.tagName("td"));
            Thread.sleep(1000);
            String tdTransactTime = String.valueOf(listTd.get(0).getText());
            Thread.sleep(2000);

            System.out.println("truyen vo" +dateTime);
            System.out.println(tdTransactTime+"laasy ra");
            String tdAmount = listTd.get(1).getText();
            String tdCheck = listTd.get(2).getText();
            System.out.println(tdTransactTime.equalsIgnoreCase(dateTime));

            if (tdTransactTime.equals(dateTime) && tdAmount.equalsIgnoreCase(amountInput)) {
                Thread.sleep(2000);

                if (typeOfTransaction.equalsIgnoreCase("Deposit") && tdCheck.equalsIgnoreCase("Credit")) {
                    System.out.println("deposit");
                    transacted = 1;
                } else if (typeOfTransaction.equalsIgnoreCase("Withdrawal") && tdCheck.equalsIgnoreCase("Debit")) {
                    System.out.println("debit");
                    transacted = 2;
                }
            } else {
                System.out.println("no");
                transacted = 0;
            }
        }

        if (transacted == 1 || transacted == 2) {
            return true;
        } else
            return false;
    }

    public void checkTransaction(String dateTime, String amountInput, String typeOfTransaction, boolean trueTransact) throws InterruptedException {
        Thread.sleep(2000);
        commonPage.verifyCondition(checkTransactionHistory(dateTime, amountInput, typeOfTransaction), trueTransact);
    }

    public boolean checkTransactionWithBalance(int balanceAmount) throws InterruptedException {

        System.out.println(balanceAmount);
        int transacted = 0;
        int tdAmount;
        String tdCheck;
        List<WebElement> listTransaction = transactionTable.findElements(By.tagName("tr"));

        for (int i = 1; i < listTransaction.size(); i++) {
            List<WebElement> listTd = listTransaction.get(i).findElements(By.tagName("td"));
            tdAmount = Integer.parseInt(listTd.get(1).getText());
            tdCheck = listTd.get(2).getText();

            if (tdCheck.equalsIgnoreCase("Debit")) {
                transacted -= tdAmount;
            } else if ((tdCheck.equalsIgnoreCase("Credit"))) {
                transacted += tdAmount;
            }
        }
        System.out.println(transacted);

        if (transacted == balanceAmount) {
            return true;
        } else
            return false;
    }

    public void balanceEqualTransaction(int balanceAmount, boolean isEqual) throws InterruptedException {
        commonPage.verifyCondition(checkTransactionWithBalance(balanceAmount), isEqual);
    }

}
