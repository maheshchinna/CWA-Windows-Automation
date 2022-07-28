package utilities;


import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement {

    public static WebElement getElementWithWaitId(WindowsDriver driver, String locator) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            try{
                WebElement element = driver.findElementByAccessibilityId(locator);
                boolean visibility=element.isDisplayed();
                //System.out.println(visibility);
                if(visibility){
                    LoggingHandler.log_info(locator + " element found");
                    return element;
                }
            }
            catch(Exception e){
                LoggingHandler.log_info(locator + " element not found, retrying");
            }
            Thread.sleep(2000);
        }
        LoggingHandler.log_error(locator + " element not found");
        return null;
    }

    public static WebElement getElementWithWaitName(WindowsDriver driver, String locator) {
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, 60);
            driverWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name(locator))
            );
            LoggingHandler.log_info(locator + " element found");
            return driver.findElementByName(locator);
        }
        catch (Exception exp){
            LoggingHandler.log_error(locator +" element not found");
        }
        return null;
    }

}
