package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import utilities.CustomWait;

import java.io.IOException;

public class Apps_Desktops_Page {

    WindowsDriver driver;

    public Apps_Desktops_Page(WindowsDriver driver) throws IOException {
        this.driver = driver;
    }

    private String desktopTabLocator ="desktopsBtn";

    private String AppsTabLocator="allAppsBtn";

    //Method to type store
    public void switchDesktopTab() throws InterruptedException {
        CustomWait.waitForElementId(driver, desktopTabLocator);
        WebElement desktopTabElement = driver.findElementByAccessibilityId(desktopTabLocator);
        desktopTabElement.click();
    }

    //Method to type store
    public void switchAppTab() {
        WebElement AppsTabElement = driver.findElementByAccessibilityId(AppsTabLocator);
        AppsTabElement.click();
    }

    public void launchAppDesktop(String AppDesktopName){
        WebElement appDesktopElement =driver.findElementByName(AppDesktopName);
        appDesktopElement.click();
    }
}
