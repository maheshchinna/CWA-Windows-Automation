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
        WebElement desktopTabElement = CustomWait.getElementWithWaitId(driver, desktopTabLocator);
        desktopTabElement.click();
    }

    //Method to type store
    public void switchAppTab() throws InterruptedException {
        WebElement AppsTabElement = CustomWait.getElementWithWaitId(driver, AppsTabLocator);;
        AppsTabElement.click();
    }

    public void launchAppDesktop(String AppDesktopName) throws InterruptedException {
        CustomWait.inBuiltWaitForName(driver,AppDesktopName);
        WebElement appDesktopElement =driver.findElementByName(AppDesktopName);
        appDesktopElement.click();
        Thread.sleep(60000);
    }
}
