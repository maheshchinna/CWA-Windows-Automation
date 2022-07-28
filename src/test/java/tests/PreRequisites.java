package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import utilities.*;

public class PreRequisites {

    @BeforeSuite

    void setUP() throws Exception {
        ScreenRecorderUtil.startRecord("Env setup");
        LoggingHandler.createFile();
        // Enabling Dev mode and installing Win App Driver
        WinAppDriverSetUp.envSetUp();

        // Download CWA Win Build
        BuildDownloadDelete.downloadCWABuild();

        // Running WinApp Driver Server
       // WinAppDriverSetUp.openWinAppServer();

        ScreenRecorderUtil.stopRecord();
    }

    @AfterTest
    void testDown() throws InterruptedException {

        // Delete downloaded CWA Win build
        BuildDownloadDelete.deleteCWABuild();
    }

}
