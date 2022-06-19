import io.appium.java_client.windows.WindowsDriver;

import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import utilities.PropertiesFile;
import java.awt.*;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class UnitTest extends PropertiesFile {

    @Test
   public void sample() throws IOException {
        Desktop desktop = Desktop.getDesktop();
        String WinAppDrv = System.getProperty("user.dir")+"\\Dependencies\\Windows Application Driver\\WinAppDriver.exe";
        desktop.open(new File(WinAppDrv));
        // Process process = new ProcessBuilder("").start();
        WindowsDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Notepad");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("deviceName", "Windows");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

        Runtime.getRuntime().exec(WinAppDrv).destroy();

    }
}
