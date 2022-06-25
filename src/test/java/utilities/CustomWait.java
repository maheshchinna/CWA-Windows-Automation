package utilities;


import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

    public static boolean waitForElementId(WindowsDriver driver, String locator) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            try{
                boolean visibility = driver.findElementByAccessibilityId(locator).isDisplayed();
                //System.out.println(visibility);
                if(visibility){
                    return true;
                }
            }
            catch(Exception e){
                System.out.println(locator + " Element not found, retrying");
            }
            Thread.sleep(1000);
        }
        return false;
    }

    public static boolean inBuiltWaitForName(WindowsDriver driver, String NameLocator) {
        WebDriverWait driverWait = new WebDriverWait(driver, 45);
        driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name(NameLocator)
                )
        );
        return false;
    }

}
