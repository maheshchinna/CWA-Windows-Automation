package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import utilities.ScreenshotCapture;
import utilities.WaitForElement;

public class Add_Account_Page {

    WindowsDriver driver;
    private String storeLocator = "EmailOrServerTextField";
    private String continueLocator = "Continue";

    public Add_Account_Page(WindowsDriver driver) {
        this.driver = driver;
    }

    //Method to type store
    public void enterStore(String storeURL) {
        int i = 0;
        WebElement storeEle = WaitForElement.getElementWithWaitName(driver, storeLocator);
        do {
            if (storeEle != null) {
                storeEle.sendKeys(storeURL);
                System.out.println(storeEle.getText());
                if ((storeEle.getText().equalsIgnoreCase(storeURL))) {
                    WebElement continueEle = WaitForElement.getElementWithWaitName(driver, continueLocator);
                    if (continueEle != null) {
                        ScreenshotCapture.takeScreenshot(driver, "store_enter.png");
                        continueEle.click();
                        break;
                    }
                } else
                    storeEle.clear();
                i++;
            }
        } while (i <= 1);
    }

}

