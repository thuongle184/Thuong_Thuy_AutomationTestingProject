package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import runner.TestRunner;

import java.util.ArrayList;
import java.util.List;

public class ManageCustomerAccountPage {

    @FindBy(css = ".border > div:nth-child(2)")
    WebElement formScroll;
    @FindBy(css = "button.btn-lg:nth-child(3)")
    WebElement customerButton;
    @FindBy(css = ".table")
    WebElement accountTable;
    @FindBy(css = ".form-control")
    WebElement searchBox;

    CommonPage commonPage = new CommonPage();

    public void clickCustomerTab() throws InterruptedException {
        Thread.sleep(1000);
        customerButton.click();
        Thread.sleep(1000);
    }

    public String[] devideName(String tempName) {
        String[] dividedName = new String[]{};
        for (int i = 0; i < tempName.length(); i++) {
            dividedName = tempName.split(" ");
        }
        return dividedName;
    }

    public List<WebElement> dataAccountTable() {
        List<WebElement> accountInforRows = null;
        if (accountTable.isDisplayed()) {
            accountInforRows = accountTable.findElements(By.tagName("tr"));
        }
        return accountInforRows;
    }

    public boolean checkCustomerAccountInformation(String fullName, String postCode, String accountNumber) throws InterruptedException {
        boolean isExist = false;
        String[] name = devideName(fullName);
        Thread.sleep(2000);
        List<WebElement> accountInforRows = dataAccountTable();

        for (int i = 1; i < accountInforRows.size(); i++) {
            List<WebElement> accountInfor = accountInforRows.get(i).findElements(By.tagName("td"));
            System.out.println(accountInfor.get(0).getText().equals(name[0]) && accountInfor.get(1).getText().equals(name[1])
                    && accountInfor.get(2).getText().equals(postCode) && accountInfor.get(3).getText().contains(accountNumber));
            Thread.sleep(2000);
            if (accountInfor.get(0).getText().equals(name[0]) && accountInfor.get(1).getText().equals(name[1])
                    && accountInfor.get(2).getText().equals(postCode) && accountInfor.get(3).getText().contains(accountNumber)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public void deleteCustomerAccount(String chosenAccount, String postCode, String accountNumber) throws InterruptedException {

        String[] accountToDelete = devideName(chosenAccount);
        List<WebElement> accountInforRows = dataAccountTable();

        for (int i = 1; i <= accountInforRows.size() - 1; i++) {
            List<WebElement> accountInfor = accountInforRows.get(i).findElements(By.tagName("td"));
            if (accountInfor.get(0).getText().equals(accountToDelete[0]) && accountInfor.get(1).getText().equals(accountToDelete[1])
                    && accountInfor.get(2).getText().equals(postCode) && accountInfor.get(3).getText().contains(accountNumber)) {

                TestRunner.driver.findElement(By.xpath("//tr[" + i + "]//button")).click();
                break;
            }
        }

    }

    public void setSearchValue(String searchValue) throws InterruptedException {
        if (searchBox.isDisplayed()) {
            searchBox.clear();
            if (!searchBox.equals(null)) {
                this.searchBox.sendKeys(searchValue);
                Thread.sleep(2000);
            }
        }
    }

    public void checkSearchSuccessfully(String searchVualueInput, boolean isSearched) {
        List<WebElement> accountInforRows = dataAccountTable();
        boolean searched = false;

        for (int i = 1; i <= accountInforRows.size() - 1; i++) {
            List<WebElement> accountInfo = accountInforRows.get(i).findElements(By.tagName("td"));
            if (accountInfo.get(0).getText().contains(searchVualueInput) || accountInfo.get(1).getText().contains(searchVualueInput)) {
                searched = true;
                break;
            }
        }

        commonPage.verifyCondition(isSearched, searched);
    }

    public void setColumnSort(String sortColumn) {
        WebElement sortedColumn = TestRunner.driver.findElement(By.linkText(sortColumn));
        searchBox.clear();
        if (!sortedColumn.equals("null")) {
            sortedColumn.click();
        }
    }

    public void verifySortResult(boolean isSorted, int columnIndex) {
        boolean message = false;

        List<WebElement> accountInfor = accountTable.findElements(By.xpath("//table/tbody/tr/td[" + columnIndex + "]"));
        List<String> firstNameSorted = new ArrayList<>();

        for (int i = 0; i <= accountInfor.size() - 1; i++) {
            String tempName = accountInfor.get(i).getText();
            firstNameSorted.add(tempName);
        }
        message = Ordering.natural().reverse().isOrdered(firstNameSorted);

        commonPage.verifyCondition(isSorted, message);

    }

    public void checkSearchUnsuccessfully(String searchVualueInput, boolean isSearched) {
        List<WebElement> accountInfoRows = dataAccountTable();
        boolean searched = true;

        for (int i = 1; i <= accountInfoRows.size() - 1; i++) {
            List<WebElement> accountInfo = accountInfoRows.get(i).findElements(By.tagName("td"));
            if (!(accountInfo.get(0).getText().contains(searchVualueInput)
                    && accountInfo.get(1).getText().contains(searchVualueInput))) {
                System.out.println(accountInfo.get(0).getText());
                System.out.println(accountInfo.get(1).getText());

                searched = false;
                break;
            }
        }

        commonPage.verifyCondition(isSearched, searched);
    }

    public void checkAccountExisted(String fullname, String postcode, String accountNumber, boolean isExisted) throws InterruptedException {
        Thread.sleep(2000);
        commonPage.verifyCondition(checkCustomerAccountInformation(fullname, postcode.trim(), accountNumber), isExisted);
    }
}