package prelaunch;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SingleLaunch_Tests {

    WindowsDriver local_driver;
    @Test(priority = 0)
    void launchDesktop() throws InterruptedException {
        local_driver = AddStore_Login_Tests.driver;
        local_driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        WebElement desktopTab = local_driver.findElementByAccessibilityId("desktopsBtn");
        desktopTab.click();

        WebElement desktop_one = local_driver.findElementByName("EN 2K22 VDA master");
        desktop_one.click();

        System.out.println("One Desktop Launch successfully");
        Thread.sleep(60000);
    }

    @Test(priority = 1)
    void launchApp() throws InterruptedException {
        local_driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        WebElement desktopTab = local_driver.findElementByAccessibilityId("desktopsBtn");
        desktopTab.click();

        WebElement appsTab = local_driver.findElementByAccessibilityId("allAppsBtn");
        appsTab.click();

        WebElement app_one = local_driver.findElementByName("Notepad 2k16 EN");
        app_one.click();
        System.out.println("One App Launch successfully");
        Thread.sleep(60000);
    }
























        /*
        WebElement launch_pass= driver.findElementByAccessibilityId("buttonFlowPanel");

        WebElement sysTrayMenu= driver.findElementByName("Notification Chevron");
        sysTrayMenu.click();

        WebElement ctxWorkspace= driver.findElementByName("Citrix Workspace");
        ctxWorkspace.click();

        WebElement advPref= driver.findElementByAccessibilityId("300");
        ctxWorkspace.click();

        WebElement conCenter= driver.findElementByAccessibilityId("Connection center");
        conCenter.click();
        */

    //driver.quit();

}
