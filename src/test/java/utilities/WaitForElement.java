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
                    System.out.println(locator + " element found");
                    return element;
                }
            }
            catch(Exception e){
                System.out.println(locator + " element not found, retrying");
            }
            Thread.sleep(2000);
        }
        System.out.println(locator + " element not found");
        return null;
    }

    public static WebElement getElementWithWaitName(WindowsDriver driver, String locator) {
        try {
            WebDriverWait driverWait = new WebDriverWait(driver, 60);
            driverWait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name(locator))
            );
            System.out.println(locator + " element found");
            return driver.findElementByName(locator);
        }
        catch (Exception exp){
            System.out.println(locator +" element not found");
        }
        return null;
    }

}
