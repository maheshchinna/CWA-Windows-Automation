package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.testng.annotations.Test;
import pages.Apps_Desktops_Page;
import utilities.JSON_Handler;
import utilities.ScreenRecorderUtil;
import utilities.LoggingHandler;


public class App_Desktop_Launch_Tests extends JSON_Handler {

    WindowsDriver driver;
    Apps_Desktops_Page apps_desktops_page;

    @Test(dependsOnGroups = "login_test", groups = "launch_test")
    void launchDesktop() throws Exception {
        ScreenRecorderUtil.startRecord("launch");
        this.driver=AddStore_Test.driver;
        apps_desktops_page =new Apps_Desktops_Page(driver);
        apps_desktops_page.switchDesktopTab();
        LoggingHandler.log_info("Launching desktop session...");
        apps_desktops_page.launchAppDesktop(getValue("desktop1"));
        LoggingHandler.log_info(getValue("desktop1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(getValue("desktop2"));
        LoggingHandler.log_info(getValue("desktop2")+" Desktop Launch successful");

    }

    @Test(priority = 1,dependsOnGroups = "login_test",groups = "launch_test")
    void launchApp() throws Exception {
        apps_desktops_page.switchAppTab();
        LoggingHandler.log_info("Launching app session...");
        apps_desktops_page.launchAppDesktop(getValue("app1"));
        LoggingHandler.log_info(getValue("app1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(getValue("app2"));
        System.out.println(getValue("app2")+" Desktop Launch successful");
        ScreenRecorderUtil.stopRecord();
        LoggingHandler.log_info(getValue("app2")+" Desktop Launch successful");
    }
}
