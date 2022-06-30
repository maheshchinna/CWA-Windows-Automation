package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.testng.annotations.Test;
import pages.Apps_Desktops_Page;
import utilities.PropertiesFile;
import java.io.IOException;

public class App_Desktop_Launch_Tests extends PropertiesFile {

    WindowsDriver driver;
    Apps_Desktops_Page apps_desktops_page;

    @Test(dependsOnGroups = "login_test", groups = "launch_test")
    void launchDesktop() throws IOException, InterruptedException {
        this.driver=AddStore_Test.driver;
        apps_desktops_page =new Apps_Desktops_Page(driver);
        apps_desktops_page.switchDesktopTab();
        System.out.println("Launching desktop session...");
        apps_desktops_page.launchAppDesktop(read_properties("desktop1"));
        System.out.println(read_properties("desktop1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(read_properties("desktop2"));
        System.out.println(read_properties("desktop2")+" Desktop Launch successful");
    }

    @Test(priority = 1,dependsOnGroups = "login_test",groups = "launch_test")
    void launchApp() throws IOException, InterruptedException {
        apps_desktops_page.switchAppTab();
        System.out.println("Launching app session...");
        apps_desktops_page.launchAppDesktop(read_properties("app1"));
        System.out.println(read_properties("app1")+" Desktop Launch successful");
        apps_desktops_page.launchAppDesktop(read_properties("app2"));
        System.out.println(read_properties("app2")+" Desktop Launch successful");
    }
}
