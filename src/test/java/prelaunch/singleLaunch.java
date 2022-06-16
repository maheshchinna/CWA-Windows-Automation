package prelaunch;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class singleLaunch {

    WindowsDriver local_driver;
    @Test(priority = 0)
    void launchDesktop() throws InterruptedException {
        local_driver = Install_AddStore_Login_Tests.driver;
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

    @Test(priority = 2,dependsOnMethods = {"launchApp"})
    void logoffSessions() throws IOException {
        String allSessionLogoff = "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe -logoffSessions";
        Runtime.getRuntime().exec(allSessionLogoff);
        System.out.println("All sessions are logged-off");
    }

    @Test(priority = 3,dependsOnMethods = {"logoffSessions"})
    void logoffCWAUser() throws IOException {
        String CWAUserLogoff = "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe -logoff";
        Runtime.getRuntime().exec(CWAUserLogoff);
        System.out.println("CWA Logoff passed");
    }

    @Test(priority = 4,dependsOnMethods = {"logoffCWAUser"})
    void uninstallCWA() throws IOException, InterruptedException {
        String uninstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /silent /uninstall";
        Runtime.getRuntime().exec(uninstallCMD);
        do {
            Thread.sleep(25000);
            System.out.println("uninstalling the build....");
        }while(new File("C:\\Program Files (x86)\\Citrix\\ICA Client").exists());
        System.out.println("Uninstall passed");
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
