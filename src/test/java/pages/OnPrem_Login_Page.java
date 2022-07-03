package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

public class OnPrem_Login_Page   {

    WindowsDriver driver;

    public OnPrem_Login_Page(WindowsDriver driver) {
        this.driver = driver;
    }

    private String usernameLocator ="username";

    private String passwordLocator="password";

    private String loginBtnLocator = "loginBtn";

    //Method to type username
    public void enterUsername(String store_username) {
        WebElement usernameEle = driver.findElementByAccessibilityId(usernameLocator);
        usernameEle.sendKeys(store_username);
    }

    //Method to type password
    public void enterPassword(String store_password) {
        WebElement passwordEle = driver.findElementByAccessibilityId(passwordLocator);
        passwordEle.sendKeys(store_password);
    }

    // Method to click on add store
    public void clickLoginBtn() {
        WebElement LoginBtnEle = driver.findElementByAccessibilityId(loginBtnLocator);
        LoginBtnEle.click();
    }

     /*public static boolean loginPage() throws InterruptedException {
        WebElement usernameElement = WaitForElement.getElementWithWaitId(driver, "usernameLocator");
        return usernameElement.isDisplayed();
    }*/
}
