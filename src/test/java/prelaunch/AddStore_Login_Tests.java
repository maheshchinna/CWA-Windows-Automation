package prelaunch;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.PropertiesFile;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddStore_Login_Tests extends PropertiesFile {

    public static WindowsDriver driver;

    @BeforeClass
    void setUp() throws IOException, InterruptedException {
        // Process process = new ProcessBuilder("").start();
        Thread.sleep(2000);
        Desktop desktop = Desktop.getDesktop();
        String WinAppDrv = System.getProperty("user.dir")+"\\Dependencies\\Windows Application Driver\\WinAppDriver.exe";
        desktop.open(new File(WinAppDrv));
        //Runtime.getRuntime().exec("Dependencies\\Windows Application Driver\\WinAppDriver.exe");
        Thread.sleep(5000);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("deviceName", "Windows");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
    }

    @Test(priority = 0)
    void addStore() throws  IOException {
        //Thread.sleep(2000);
        WebDriverWait driverWait =new WebDriverWait(driver, 10);
       /* driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("EmailOrServerTextField")
                ));*/
        WebElement storeURL = driver.findElementByName("EmailOrServerTextField");
        storeURL.sendKeys(read_properties("storeURL"));
        driver.findElementByName("Continue").click();
        System.out.println("Store Added successfully");
       /* driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("username")
                )
        );*/

    }

    @Test(priority = 1, dependsOnMethods = {"addStore"},groups = "post_login")
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

