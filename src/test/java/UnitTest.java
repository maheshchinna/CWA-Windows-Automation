import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Add_Account_Page;
import pages.Apps_Desktops_Page;
import pages.OnPrem_Login_Page;
import utilities.GetSetJSONData;
import utilities.WaitForElement;
import utilities.WinAppDriverSetUp;
import java.io.IOException;

public class UnitTest  extends GetSetJSONData {

    public static void main(String[] args) throws IOException, InterruptedException {

        testSample();

    }

    public static void testSample() throws InterruptedException, IOException {
        WinAppDriverSetUp.openWinAppServer();
        WindowsDriver driver = WinAppDriverSetUp.setDriverForCWA();

        /*Add_Account_Page add_account_page = new Add_Account_Page(driver);
        add_account_page.enterStore(getValue("storeURL"));
        //   add_account_page.clickContinue();
        WebElement usernameElement = WaitForElement.getElementWithWaitId(driver, "username");
        Assert.assertTrue(usernameElement != null);
        System.out.println("Store Added successfully");

        OnPrem_Login_Page onPrem_login_page = new OnPrem_Login_Page(driver);
        onPrem_login_page.enterUsername(getValue("store_username"));
        onPrem_login_page.enterPassword(getValue("store_password"));
        onPrem_login_page.clickLoginBtn();*/
        WebElement sspHomeElement = WaitForElement.getElementWithWaitId(driver, "desktopsBtn");
        if (sspHomeElement.isDisplayed()) {
            Apps_Desktops_Page apps_desktops_page = new Apps_Desktops_Page(driver);
            apps_desktops_page.switchDesktopTab();
            System.out.println("Launching desktop session...");
            Thread.sleep(5000);
            apps_desktops_page.switchAppTab();

        }
    }
}

