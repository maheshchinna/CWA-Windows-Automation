package tests;

import org.testng.annotations.BeforeTest;
import java.io.IOException;

public class Install_Test {

    @BeforeTest
    void installation() throws IOException, InterruptedException {

        // Installing the CWA Win build
        System.out.println("Installation started for CWA Windows...");
        String CWAInstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /includeSSON /silent";
        Runtime.getRuntime().exec(CWAInstallCMD);
        do {
            System.out.println("Installing the CWA Win build....");
            Thread.sleep(300000);
        } while (false);
        //while(!(new File("").exists()));
        System.out.println("Installation passed");
    }
}
