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
            if (count==120){
                Assert.assertTrue(false,"Uninstall failed");
                break;
            }
            else {
                Thread.sleep(5000);
                System.out.println("uninstalling the build....");
                count++;
            }
        }while(new File("C:\\Program Files (x86)\\Citrix\\ICA Client").exists());
        System.out.println("Uninstall passed");
        Thread.sleep(3000);
    }

}
