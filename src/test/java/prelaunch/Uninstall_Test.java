package prelaunch;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Uninstall_Test {
    @AfterTest
    void uninstallCWA() throws IOException, InterruptedException {
        String uninstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /silent /uninstall";
        Runtime.getRuntime().exec(uninstallCMD);
        do {
            Thread.sleep(25000);
            System.out.println("uninstalling the build....");
        }while(new File("C:\\Program Files (x86)\\Citrix\\ICA Client").exists());
        System.out.println("Uninstall passed");
    }

}
