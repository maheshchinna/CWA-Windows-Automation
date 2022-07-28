package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import utilities.LoggingUtil;
import utilities.ScreenshotCapture;
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
        LoggingUtil.log_info("Switching to desktop tab");
        WebElement desktopTabElement = WaitForElement.getElementWithWaitId(driver, desktopTabLocator);
        //System.out.println(desktopTabElement.getText());
        if (desktopTabElement!=null) {
            Thread.sleep(5000);
            desktopTabElement.click();
            LoggingUtil.log_info("Switched to desktop tab");
            Thread.sleep(2000);
            ScreenshotCapture.takeScreenshot(driver,"screenshots/desktop_tab_switch_pass.png");
        }
    }

    //Method to switch app tab
    public void switchAppTab() throws InterruptedException {
        LoggingUtil.log_info("Switching to app tab");
        WebElement appsTabElement = WaitForElement.getElementWithWaitId(driver, AppsTabLocator);;
        if (appsTabElement!=null) {
            Thread.sleep(5000);
            appsTabElement.click();
            LoggingUtil.log_info("Switched to app tab");
            Thread.sleep(2000);
            ScreenshotCapture.takeScreenshot(driver,"screenshots/app_tab_switch_pass.png");
        }
    }

    public void launchAppDesktop(String AppDesktopName) throws InterruptedException {
        WaitForElement.getElementWithWaitName(driver,AppDesktopName);
        WebElement appDesktopElement =driver.findElementByName(AppDesktopName);
        if (appDesktopElement!=null) {
            appDesktopElement.click();
            LoggingUtil.log_info("Clicked on "+AppDesktopName+" resource");
        }
        Thread.sleep(60000);
    }
}
