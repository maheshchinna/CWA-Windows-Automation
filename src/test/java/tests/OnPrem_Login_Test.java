package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnPrem_Login_Page;
import utilities.*;

public class OnPrem_Login_Test extends JSON_Read_Write {

    WindowsDriver driver;

    @Test(dependsOnGroups = "add_Store", groups = "login_test")
    void loginTest() throws Exception {
        ScreenRecorderUtil.startRecord("login");
        this.driver=AddStore_Test.driver;
        OnPrem_Login_Page onPrem_login_page=new OnPrem_Login_Page(driver);
        onPrem_login_page.enterUsername(getConfigValue("store_username"));
        onPrem_login_page.enterPassword(getConfigValue("store_password"));
        ScreenshotCapture.takeScreenshot(driver,"credentials_enter.png");
        onPrem_login_page.clickLoginBtn();
        WebElement desktopsBtnElement = WaitForElement.getElementWithWaitId(driver, "desktopsBtn");
        Assert.assertTrue(desktopsBtnElement!=null);
        LoggingHandler.log_info("Login completed successfully");
        ScreenshotCapture.takeScreenshot(driver,"cwa_user_login_pass.png");
        ScreenRecorderUtil.stopRecord();
    }
}

