package tests;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OnPrem_Login_Page;
import utilities.WaitForElement;
import utilities.PropertiesFile;

import java.io.IOException;

public class OnPrem_Login_Test extends PropertiesFile {

    WindowsDriver driver;

    @Test(dependsOnGroups = "add_Store", groups = "login_test")
    void loginTest() throws IOException, InterruptedException {
        this.driver=AddStore_Test.driver;
        OnPrem_Login_Page onPrem_login_page=new OnPrem_Login_Page(driver);
        onPrem_login_page.enterUsername(read_properties("store_username"));
        onPrem_login_page.enterPassword(read_properties("store_password"));
        onPrem_login_page.clickLoginBtn();
        WebElement sspHomeElement = WaitForElement.getElementWithWaitId(driver, "myHomeBtn");
        Assert.assertTrue(sspHomeElement!=null);
        System.out.println("Login completed successfully");
    }
}

