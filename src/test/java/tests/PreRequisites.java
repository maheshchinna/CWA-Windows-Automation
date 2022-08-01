package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import utilities.*;

import java.io.IOException;

public class PreRequisites {

    @BeforeSuite

    void setUP() throws Exception {

        // Create screen recording folder unique for every run
        ScreenRecorderUtil.createRecordingFolder();

        // Create screenshot folder unique for every run
        ScreenshotCapture.createScreenshotFolder();

        // Create unique logging file every run
        LoggingHandler.createFile();

        ScreenRecorderUtil.startRecord("Env setup");

        // Enabling Dev mode and installing Win App Driver
        WinAppDriverSetUp.envSetUp();

        // Download CWA Win Build
        BuildDownloadDelete.downloadCWABuild();

        // Running WinApp Driver Server
        WinAppDriverSetUp.openWinAppServer();

        ScreenRecorderUtil.stopRecord();
    }

    @AfterTest
    void testDown() {

        // Delete downloaded CWA Win build
        BuildDownloadDelete.deleteCWABuild();

        //Close the Win App Driver Server connection
        try {
            Runtime.getRuntime().exec("taskkill /im WinAppDriver.exe /f");
        }
        catch (IOException exp){
            LoggingHandler.log_info("Exception to close the Win App Driver");
        }
        LoggingHandler.log_info("Win App Driver Server connection closed");
        LoggingHandler.log_info("Completed the execution!!!!!!");
    }

}
