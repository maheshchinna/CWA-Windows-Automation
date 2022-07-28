package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import utilities.BuildDownloadDelete;
import utilities.LoggingUtil;
import utilities.WinAppDriverSetUp;

import java.io.IOException;

public class PreRequisites {

    @BeforeSuite
    void setUP() throws IOException, InterruptedException {
        LoggingUtil.createFile();
        // Enabling Dev mode and installing Win App Driver
        WinAppDriverSetUp.envSetUp();

        // Download CWA Win Build
        BuildDownloadDelete.downloadCWABuild();

        // Running WinApp Driver Server
        WinAppDriverSetUp.openWinAppServer();


    }

    @AfterTest
    void testDown() throws InterruptedException {

        // Delete downloaded CWA Win build
        BuildDownloadDelete.deleteCWABuild();
    }

}
