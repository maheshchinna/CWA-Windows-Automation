package utilities;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class WinAppDriverSetUp {

    public static void envSetUp(){
        try {
            final String[] enableDevMode = {"regedit", "/s", System.getProperty("user.dir") + "\\Dependencies\\devModeOn.reg"};
            Runtime.getRuntime().exec(enableDevMode);
            Thread.sleep(1000);
            LoggingHandler.log_info("Dev Mode enabled");

            boolean winAppDriverInstallCheck = new File("C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe").exists();
            if (!winAppDriverInstallCheck) {
                LoggingHandler.log_info("Installation started for Win App Driver...");
                final String installWinAppDriver = System.getProperty("user.dir") + "\\Dependencies\\WindowsApplicationDriver-1.2.99-win-x64.exe /silent";
                Runtime.getRuntime().exec(installWinAppDriver);
                do {
                    Thread.sleep(5000);
                    LoggingHandler.log_info("Installing Win App Driver...");
                } while (!(new File("C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe").exists()));
                LoggingHandler.log_info("Win App Driver installed");
            } else
                LoggingHandler.log_info("Win App Driver already installed");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    public static void openWinAppServer() {
        Desktop desktop = Desktop.getDesktop();
        try {
            String WinAppDrv = "C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe";
            desktop.open(new File(WinAppDrv));
            Thread.sleep(5000);
            LoggingHandler.log_info("Win App Driver server started..");
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    public static WindowsDriver setDriverForCWA() {
        WindowsDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("ms:waitForAppLaunch", 50);
        capabilities.setCapability("deviceName", "Windows");
        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        } catch (MalformedURLException exp) {
            exp.printStackTrace();
        }
        return driver;
    }
}
