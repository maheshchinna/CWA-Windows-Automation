package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import utilities.BuildDownloadDelete;
<<<<<<< HEAD
import utilities.ScreenRecorderUtil;
=======
import utilities.LoggingUtil;
>>>>>>> feature-change
import utilities.WinAppDriverSetUp;

import java.io.IOException;

public class PreRequisites {

    @BeforeSuite
<<<<<<< HEAD
    void setUP() throws Exception {
        ScreenRecorderUtil.startRecord("Env setup");
=======
    void setUP() throws IOException, InterruptedException {
        LoggingUtil.createFile();
>>>>>>> feature-change
        // Enabling Dev mode and installing Win App Driver
        WinAppDriverSetUp.envSetUp();

        // Download CWA Win Build
        BuildDownloadDelete.downloadCWABuild();

        // Running WinApp Driver Server
        WinAppDriverSetUp.openWinAppServer();
<<<<<<< HEAD
        ScreenRecorderUtil.stopRecord();
=======


>>>>>>> feature-change
    }

    @AfterTest
    void testDown() throws InterruptedException {

        // Delete downloaded CWA Win build
        BuildDownloadDelete.deleteCWABuild();
    }

}
