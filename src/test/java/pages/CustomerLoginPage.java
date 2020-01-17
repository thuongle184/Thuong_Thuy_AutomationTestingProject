package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CustomerLoginPage {

    @FindBy(id = "userSelect")
    WebElement usernameSelector;

    @FindBy(css = "button.btn:nth-child(2)")
    WebElement loginButton;

    @FindBy(css = ".logout")
    WebElement logoutButton;

    @FindBy(xpath = "//html/body/div[3]/div/div[2]/div/div[1]/strong/span")
    WebElement welcomeName;

    CommonPage commonPage = new CommonPage();

    public void selectUserName(String usernameSelected) throws InterruptedException {
        Thread.sleep(4000);
        if (!(usernameSelector == null)) {
            usernameSelector.click();
        }
        List<WebElement> listCustomerName = usernameSelector.findElements(By.tagName("option"));
        for (WebElement customerName : listCustomerName) {
            if (customerName.getText().toLowerCase().equalsIgnoreCase(usernameSelected)) {
                customerName.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    public boolean checkLoginButtonIsShown() {
        return loginButton.isDisplayed();
    }

    public void verifyUserCanClickLogin(boolean able) {
        commonPage.verifyCondition(able, checkLoginButtonIsShown());
    }

    public void clickLoginButton() throws InterruptedException {
        if (checkLoginButtonIsShown()) {
            Thread.sleep(1000);
            loginButton.click();
        }
    }

    public void verifyNavigateToDetailPage(String customerNameSelected, boolean logged) throws InterruptedException {
        boolean isLogged = false;
        Thread.sleep(2000);

        if (logoutButton.isDisplayed() && welcomeName.isDisplayed()) {
            Thread.sleep(2000);
            if (welcomeName.getText().trim().toLowerCase().equalsIgnoreCase(customerNameSelected))
                isLogged = true;
        }
        commonPage.verifyCondition(logged, isLogged);
    }

    public void buttonNotAppear(boolean loginBtnDisplayed) {
        commonPage.verifyCondition(loginBtnDisplayed, checkLoginButtonIsShown());
    }


}
