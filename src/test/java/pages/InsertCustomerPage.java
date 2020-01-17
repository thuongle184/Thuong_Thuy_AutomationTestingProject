package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsertCustomerPage {

    @FindBy(css = "div.form-group:nth-child(1) > input:nth-child(2)")
    WebElement firstname;

    @FindBy(css = "div.form-group:nth-child(2) > input:nth-child(2)")
    WebElement lastname;

    @FindBy(css = "div.form-group:nth-child(3) > input:nth-child(2)")
    WebElement postcode;

    @FindBy(css = "button.btn:nth-child(4)")
    WebElement addCustomerBtn;

    public void setUserInformation(String firstnameInput, String lastnameInput, String postcodeInput) throws InterruptedException {
        this.firstname.clear();
        Thread.sleep(1000);
        if (!firstnameInput.equals("null")) {
            this.firstname.sendKeys(firstnameInput);
            Thread.sleep(2000);
        }
        this.lastname.clear();
        Thread.sleep(1000);
        if (!lastnameInput.equals("null")) {
            this.lastname.sendKeys(lastnameInput);
            Thread.sleep(2000);
        }
        this.postcode.clear();
        Thread.sleep(1000);
        if (!postcodeInput.equals("null")) {
            this.postcode.sendKeys(postcodeInput);
            Thread.sleep(2000);
        }
    }

    public void clickSubmit() {
        addCustomerBtn.click();
    }

}
