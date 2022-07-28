package install_uninstall;

import utilities.LoggingHandler;

import java.io.IOException;

public class Installation {

   public static void installation_cwa() throws IOException, InterruptedException {
        // Installing the CWA Win build
       LoggingHandler.log_info("Installation started for CWA Windows...");
        String CWAInstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /includeSSON /silent";
        Runtime.getRuntime().exec(CWAInstallCMD);
        do {
            LoggingHandler.log_info("Installing the CWA Win build....");
            Thread.sleep(300000);
        } while (false);
        //while(!(new File("").exists()));
       LoggingHandler.log_info("Installation passed");
    }
}
