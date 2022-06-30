package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitForElement;
import utilities.PropertiesFile;

import java.io.IOException;

public class Add_Account_Page extends PropertiesFile {

 WindowsDriver driver;

 public Add_Account_Page(WindowsDriver driver) throws IOException {
  this.driver = driver;
 }

 private String storeLocator ="EmailOrServerTextField";

 private String continueLocator="Continue";

  //Method to type store
  public void enterStore() throws IOException {
   WebElement storeEle = WaitForElement.getElementWithWaitName(driver, storeLocator);
   if (storeEle != null) {
    storeEle.sendKeys(read_properties("storeURL"));
   }
  }

  // Method to click on add store
  public void clickContinue() {
   WebElement continueEle = WaitForElement.getElementWithWaitName(driver, continueLocator);
   if (continueEle != null) {
    continueEle.click();
   }
  }

 }

