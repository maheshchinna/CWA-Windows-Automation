package prelaunch;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.PropertiesFile;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Install_AddStore_Login_Tests extends PropertiesFile {

    public static WindowsDriver driver;

    @Test(priority = 0)
    void installation() throws IOException, InterruptedException {

        String CWAInstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /includeSSON /silent";
        Runtime.getRuntime().exec(CWAInstallCMD);
        do {
            System.out.println("Installing the build....");
            Thread.sleep(150000);
            System.out.println("Installing the build....");
        } while (false);
        //while(!(new File("").exists()));
        System.out.println("Installation passed");
    }

    @Test(priority = 1)
    void setUp() throws IOException {
        //Runtime.getRuntime().exec("Dependencies\\Windows Application Driver\\WinAppDriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("deviceName", "Windows");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
    }


    @Test(priority = 2, dependsOnMethods = {"setUp"})
    void addStore() throws InterruptedException, IOException {
        Thread.sleep(2000);
        WebElement storeURL = driver.findElementByName("EmailOrServerTextField");
        storeURL.sendKeys(read_properties("storeURL"));
        driver.findElementByName("Continue").click();
        System.out.println("Store Added successfully");
    }

    @Test(priority = 3, dependsOnMethods = {"addStore"})
    void loginTest() throws InterruptedException, IOException {
        Thread.sleep(2000);
        WebElement userName = driver.findElementByAccessibilityId("username");
        userName.sendKeys(read_properties("store_username"));
        WebElement password = driver.findElementByAccessibilityId("password");
        password.sendKeys(read_properties("store_password"));
        driver.findElementByAccessibilityId("loginBtn").click();
        System.out.println("Login completed successfully");
    }

    //MyScreenRecorder.stopRecording();

        /*
        WebElement launch_pass= driver.findElementByAccessibilityId("buttonFlowPanel");

        WebElement sysTrayMenu= driver.findElementByName("Notification Chevron");
        sysTrayMenu.click();

        WebElement ctxWorkspace= driver.findElementByName("Citrix Workspace");
        ctxWorkspace.click();

        WebElement advPref= driver.findElementByAccessibilityId("300");
        ctxWorkspace.click();

        WebElement conCenter= driver.findElementByAccessibilityId("Connection center");
        conCenter.click();
        */

}

