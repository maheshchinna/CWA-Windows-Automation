package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.testng.annotations.Test;
import pages.Apps_Desktops_Page;
import utilities.GetSetJSONData;
import utilities.ScreenshotCapture;

public class App_Desktop_Launch_Tests extends GetSetJSONData {

    WindowsDriver driver;
    Apps_Desktops_Page apps_desktops_page;

    @Test(dependsOnGroups = "login_test", groups = "launch_test")
    void launchDesktop() throws InterruptedException {
        this.driver=AddStore_Test.driver;
        apps_desktops_page =new Apps_Desktops_Page(driver);
        apps_desktops_page.switchDesktopTab();
        System.out.println("Launching desktop session...");
        apps_desktops_page.launchAppDesktop(getValue("desktop1"));
        System.out.println(getValue("desktop1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(getValue("desktop2"));
        System.out.println(getValue("desktop2")+" Desktop Launch successful");

    }

    @Test(priority = 1,dependsOnGroups = "login_test",groups = "launch_test")
    void launchApp() throws InterruptedException {
        apps_desktops_page.switchAppTab();
        System.out.println("Launching app session...");
        apps_desktops_page.launchAppDesktop(getValue("app1"));
        System.out.println(getValue("app1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(getValue("app2"));
        System.out.println(getValue("app2")+" Desktop Launch successful");

    }
}
