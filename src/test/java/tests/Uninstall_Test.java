package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;

public class Uninstall_Test {

    @AfterTest
    void uninstallCWA() throws IOException, InterruptedException {
        String uninstallCMD = System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe /silent /uninstall";
        Runtime.getRuntime().exec(uninstallCMD);
        int count=0;
        do {
            System.out.println("Uninstalling the CWA Win build....");
            Thread.sleep(5000);
            count++;
            if (count==120){
                Assert.assertTrue(false,"Uninstall failed");
                break;
            }
        }while(new File("C:\\Program Files (x86)\\Citrix\\ICA Client").exists());
        System.out.println("Uninstall passed");

    }

}
