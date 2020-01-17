package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class OpenAccountPage {

    @FindBy(id = "userSelect")
    WebElement userSelect;

    @FindBy(xpath = "//div[2]/div/div[1]/button[2]")
    WebElement openAccountTab;

    @FindBy(id = "currency")
    WebElement currency;

    @FindBy(xpath = "//div[2]/div/div/form/button")
    WebElement processBtn;

    CommonPage commonPage = new CommonPage();

    public void clickOpenAccountTab() {
        openAccountTab.click();
    }

    public void checkUserInformation(String fullnameInput, Boolean success) {

        List<WebElement> userList = userSelect.findElements(By.tagName("option"));
        Boolean check = false;
        for (WebElement user : userList) {
            if (user.getText().equals(fullnameInput)) {
                check = true;
                break;
            }
        }
        commonPage.verifyCondition(check, success);
    }

    public void getUserName(String usernameInput) throws InterruptedException {
        Select userSelects = new Select(userSelect);
        Thread.sleep(1000);
        userSelects.selectByVisibleText(usernameInput);
    }

    public void getCurrency(String currencyInput) throws InterruptedException {
        Select userSelects = new Select(currency);
        Thread.sleep(1000);
        userSelects.selectByVisibleText(currencyInput);
    }

    public void clickProcess() throws InterruptedException {
        Thread.sleep(1000);
        processBtn.click();
    }

}
