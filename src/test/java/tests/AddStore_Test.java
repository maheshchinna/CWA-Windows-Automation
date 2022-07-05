package tests;

import io.appium.java_client.windows.WindowsDriver;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Add_Account_Page;
import utilities.WaitForElement;
import utilities.WinAppDriverSetUp;
import utilities.GetSetJSONData;
import java.io.IOException;


public class AddStore_Test extends GetSetJSONData{

    public static WindowsDriver driver;

    @BeforeClass
    void setUp() throws IOException, InterruptedException {
        WinAppDriverSetUp.openWinAppServer();
        driver = WinAppDriverSetUp.setDriverForCWA();
        System.out.println("SSP started..");
    }

    @Test(groups = "add_Store")
    void addStore() throws  InterruptedException {
        Add_Account_Page add_account_page = new Add_Account_Page(driver);
        add_account_page.enterStore(getValue("storeURL"));
        add_account_page.clickContinue();
        WebElement usernameElement = WaitForElement.getElementWithWaitId(driver, "username");
        Assert.assertTrue(usernameElement != null);
        System.out.println("Store Added successfully");
    }

}

