package install_uninstall;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import utilities.LoggingUtil;

import java.io.File;
import java.io.IOException;

public class Uninstallation {

    public static void uninstall_cwa() throws IOException, InterruptedException {
        String uninstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /silent /uninstall";
        Runtime.getRuntime().exec(uninstallCMD);
        int count=0;
        do {
            LoggingUtil.log_info("Uninstalling the CWA Win build....");
            Thread.sleep(5000);
            count++;
            if (count==120){
                Assert.assertTrue(false,"Uninstall failed");
                LoggingUtil.log_error("Uninstall failed");
                break;
            }
        }while(new File("C:\\Program Files (x86)\\Citrix\\ICA Client").exists());
        LoggingUtil.log_info("Uninstall passed");
    }

}
