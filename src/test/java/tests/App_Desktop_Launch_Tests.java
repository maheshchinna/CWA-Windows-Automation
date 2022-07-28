package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.testng.annotations.Test;
import pages.Apps_Desktops_Page;
import utilities.GetSetJSONData;
<<<<<<< HEAD
import utilities.ScreenRecorderUtil;
=======
import utilities.LoggingUtil;
>>>>>>> feature-change
import utilities.ScreenshotCapture;

import java.io.IOException;

public class App_Desktop_Launch_Tests extends GetSetJSONData {

    WindowsDriver driver;
    Apps_Desktops_Page apps_desktops_page;

    @Test(dependsOnGroups = "login_test", groups = "launch_test")
    void launchDesktop() throws Exception {
        ScreenRecorderUtil.startRecord("launch");
        this.driver=AddStore_Test.driver;
        apps_desktops_page =new Apps_Desktops_Page(driver);
        apps_desktops_page.switchDesktopTab();
        LoggingUtil.log_info("Launching desktop session...");
        apps_desktops_page.launchAppDesktop(getValue("desktop1"));
        LoggingUtil.log_info(getValue("desktop1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(getValue("desktop2"));
        LoggingUtil.log_info(getValue("desktop2")+" Desktop Launch successful");

    }

    @Test(priority = 1,dependsOnGroups = "login_test",groups = "launch_test")
    void launchApp() throws Exception {
        apps_desktops_page.switchAppTab();
        LoggingUtil.log_info("Launching app session...");
        apps_desktops_page.launchAppDesktop(getValue("app1"));
        LoggingUtil.log_info(getValue("app1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(getValue("app2"));
<<<<<<< HEAD
        System.out.println(getValue("app2")+" Desktop Launch successful");
        ScreenRecorderUtil.stopRecord();
=======
        LoggingUtil.log_info(getValue("app2")+" Desktop Launch successful");
>>>>>>> feature-change

    }
}
