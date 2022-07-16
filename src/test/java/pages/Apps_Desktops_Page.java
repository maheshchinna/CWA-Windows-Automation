package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitForElement;
public class Apps_Desktops_Page {

    WindowsDriver driver;

    public Apps_Desktops_Page(WindowsDriver driver) {
        this.driver = driver;
    }

    private String desktopTabLocator ="desktopsBtn";

    private String AppsTabLocator="allAppsBtn";

    //Method to switch desktop tab
    public void switchDesktopTab() throws InterruptedException {
        System.out.println("Switching to desktop tab");
        WebElement desktopTabElement = WaitForElement.getElementWithWaitId(driver, desktopTabLocator);
        System.out.println(desktopTabElement.getText());
        if (desktopTabElement!=null) {
            Thread.sleep(5000);
            desktopTabElement.click();
            System.out.println("Switched to desktop tab");
        }
    }

    //Method to switch app tab
    public void switchAppTab() throws InterruptedException {
        System.out.println("Switching to app tab");
        WebElement appsTabElement = WaitForElement.getElementWithWaitId(driver, AppsTabLocator);;
        if (appsTabElement!=null) {
            Thread.sleep(5000);
            appsTabElement.click();
            System.out.println("Switched to app tab");
        }
    }

    public void launchAppDesktop(String AppDesktopName) throws InterruptedException {
        WaitForElement.getElementWithWaitName(driver,AppDesktopName);
        WebElement appDesktopElement =driver.findElementByName(AppDesktopName);
        if (appDesktopElement!=null) {
            appDesktopElement.click();
            System.out.println("Clicked on "+AppDesktopName+" resource");
        }
        Thread.sleep(60000);
    }
}
