package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnPrem_Login_Page;
import utilities.ScreenshotCapture;
import utilities.WaitForElement;
import utilities.GetSetJSONData;

public class OnPrem_Login_Test extends GetSetJSONData {

    WindowsDriver driver;

    @Test(dependsOnGroups = "add_Store", groups = "login_test")
    void loginTest() throws InterruptedException {
        this.driver=AddStore_Test.driver;
        OnPrem_Login_Page onPrem_login_page=new OnPrem_Login_Page(driver);
        onPrem_login_page.enterUsername(getValue("store_username"));
        onPrem_login_page.enterPassword(getValue("store_password"));
        ScreenshotCapture.takeScreenshot(driver,"screenshots/credentials_enter.png");
        onPrem_login_page.clickLoginBtn();
        WebElement desktopsBtnElement = WaitForElement.getElementWithWaitId(driver, "desktopsBtn");
        Assert.assertTrue(desktopsBtnElement!=null);
        System.out.println("Login completed successfully");
        ScreenshotCapture.takeScreenshot(driver,"screenshots/cwa_user_login_pass.png");
    }
}

