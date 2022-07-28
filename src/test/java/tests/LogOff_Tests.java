package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.LoggingUtil;
import utilities.ScreenshotCapture;
import utilities.WaitForElement;

import java.io.IOException;

public class LogOff_Tests {
    public static WindowsDriver driver;

    @Test(dependsOnGroups = "launch_test")
    void logoffSessions() throws IOException, InterruptedException {
        this.driver=AddStore_Test.driver;
        String allSessionLogoff = "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe -logoffSessions";
        Runtime.getRuntime().exec(allSessionLogoff);
        LoggingUtil.log_info("All sessions are logged-off");
        Thread.sleep(5000);
    }

    @Test(priority = 1,dependsOnGroups = "login_test")
    void logoffCWAUser() throws IOException, InterruptedException {
        String CWAUserLogoff = "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe -logoff";
        Runtime.getRuntime().exec(CWAUserLogoff);
        LoggingUtil.log_info("CWA user logged-off");
        WebElement sspHomeElement = WaitForElement.getElementWithWaitId(driver, "myHomeBtn");
        sspHomeElement.click();
        Thread.sleep(2000);
        ScreenshotCapture.takeScreenshot(driver,"screenshots/cwa_user_logoff_pass.png");
    }
}
