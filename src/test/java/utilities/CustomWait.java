package utilities;


import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

    public static WebElement getElementWithWaitId(WindowsDriver driver, String locator) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            try{
                WebElement element = driver.findElementByAccessibilityId(locator);
                boolean visibility=element.isDisplayed();
                //System.out.println(visibility);
                if(visibility){
                    return element;
                }

            }
            catch(Exception e){
                System.out.println(locator + " Element not found, retrying");
            }
            Thread.sleep(2000);
        }
        return null;
    }

    public static void inBuiltWaitForName(WindowsDriver driver, String NameLocator) {
        WebDriverWait driverWait = new WebDriverWait(driver, 45);
        driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name(NameLocator)
                )
        );

    }

}
