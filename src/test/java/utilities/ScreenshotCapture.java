package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenshotCapture {
    public static void takeScreenshot(WebDriver driver, String destinationPath) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(destinationPath));
        }
        catch (IOException ex){
            ex.printStackTrace();
            LoggingUtil.log_error("Screen capture issue due to IOException");
        }

    }
}
