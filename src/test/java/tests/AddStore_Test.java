package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Add_Account_Page;
import utilities.*;
public class AddStore_Test extends JSON_Read_Write {

    public static WindowsDriver driver;

    @BeforeClass
    void setUp() {
        ScreenRecorderUtil.startRecord("add_store");
        // Set Win App driver to CWA Win SSP Window
        WinAppDriverSetUp.openWinAppServer();
        driver = WinAppDriverSetUp.setDriverForCWA();
        LoggingHandler.log_info("SSP started..");
        ScreenshotCapture.takeScreenshot(driver,"ssp_launch_pass.png");
    }

    @Test(groups = "add_Store")
    void addStore() throws Exception {
        Add_Account_Page add_account_page = new Add_Account_Page(driver);
        add_account_page.enterStore(getConfigValue("storeURL"));
        WebElement usernameElement = WaitForElement.getElementWithWaitId(driver, "username");
        Assert.assertTrue(usernameElement != null);
        LoggingHandler.log_info("Store Added successfully");
        ScreenshotCapture.takeScreenshot(driver,"add_account_pass.png");
        ScreenRecorderUtil.stopRecord();
    }

}

