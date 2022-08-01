package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotCapture {
    public static File screenShotFolder ;
    public static void createScreenshotFolder() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY HH.mm");
        screenShotFolder = new File("screenshots/screenshot_at_" + dateFormat.format(new Date()));
        screenShotFolder.mkdir();
    }
    public static void takeScreenshot(WebDriver driver, String filename) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(screenShotFolder+"/"+filename));
        }
        catch (IOException ex){
            ex.printStackTrace();
            LoggingHandler.log_error("Screen capture issue due to IOException");
        }

    }
}
