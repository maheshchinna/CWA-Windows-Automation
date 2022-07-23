package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import utilities.ScreenshotCapture;
import utilities.WaitForElement;

public class Add_Account_Page  {

 WindowsDriver driver;

 public Add_Account_Page(WindowsDriver driver) {
  this.driver = driver;
 }

 private String storeLocator ="EmailOrServerTextField";

 private String continueLocator="Continue";

  //Method to type store
  public void enterStore(String storeURL) {
   WebElement storeEle = WaitForElement.getElementWithWaitName(driver, storeLocator);
   for (int i = 0; i < 3; i++) {
    if (storeEle != null) {
     storeEle.sendKeys(storeURL);
     System.out.println(storeEle.getText());
     if ((storeEle.getText().equalsIgnoreCase(storeURL))) {
      WebElement continueEle = WaitForElement.getElementWithWaitName(driver, continueLocator);
      if (continueEle != null) {
       ScreenshotCapture.takeScreenshot(driver,"screenshots/store_enter.png");
       continueEle.click();
       break;
      }
     }
     else
      storeEle.clear();
    }
   }
  }
 }

