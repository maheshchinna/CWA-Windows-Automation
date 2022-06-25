package utilities;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WinAppDriverSetUp {

    public static void openWinAppServer() throws IOException, InterruptedException {
        Desktop desktop = Desktop.getDesktop();
        String WinAppDrv = System.getProperty("user.dir")+"\\Dependencies\\Windows Application Driver\\WinAppDriver.exe";
        desktop.open(new File(WinAppDrv));
        Thread.sleep(5000);
    }

    public static WindowsDriver setDriverForCWA() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("deviceName", "Windows");
        return new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }
}
