package utilities;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class WinAppDriverSetUp {

    public static void envSetUp() throws IOException, InterruptedException {
        String[] enableDevMode = {"regedit", "/s", System.getProperty("user.dir") + "\\Dependencies\\devModeOn.reg"};
        Runtime.getRuntime().exec(enableDevMode);
        Thread.sleep(1000);
        System.out.println("Dev Mode enabled");

        boolean winAppDriverInstallCheck = new File("C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe").exists();
        if (!winAppDriverInstallCheck) {
            System.out.println("Installation started for Win App Driver...");
            String installWinAppDriver = System.getProperty("user.dir") + "\\Dependencies\\WindowsApplicationDriver-1.2.99-win-x64.exe /silent";
            Runtime.getRuntime().exec(installWinAppDriver);
            do {
                Thread.sleep(2000);
                System.out.println("Installing Win App Driver...");
            } while (!(new File("C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe").exists()));
            System.out.println("Win App Driver installed");
        } else
            System.out.println("Win App Driver already installed");
    }

    public static void openWinAppServer() throws IOException, InterruptedException {
        Desktop desktop = Desktop.getDesktop();
        String WinAppDrv = "C:\\Program Files\\Windows Application Driver\\WinAppDriver.exe";
        desktop.open(new File(WinAppDrv));
        Thread.sleep(5000);
        System.out.println("Win App Driver server started..");
    }

    public static WindowsDriver setDriverForCWA() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\Citrix\\ICA Client\\SelfServicePlugin\\SelfService.exe");
        capabilities.setCapability("platformName", "Windows 10");
        capabilities.setCapability("createSessionTimeout", 120000);
        capabilities.setCapability("deviceName", "Windows");
        return new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }
}
