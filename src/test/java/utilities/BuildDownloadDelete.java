package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BuildDownloadDelete extends JSON_Read_Write {

    public static void downloadCWABuild() throws InterruptedException {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Builds");
        prefs.put("safebrowsing.enabled", true);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        String branch = getConfigValue("branch");
        setRunValue("previouslyRunBranch", branch);
        String branch_url = getConfigValue("url") + "_" + branch + "_ICAClientCore";
        LoggingHandler.log_info("Branch Info " + branch_url);
        driver.get(branch_url);

        driver.findElement(By.linkText("Log in as guest")).click();

        // log branch info
        LoggingHandler.log_info("Branch => " + driver.getTitle());

        // Switch to Successful Builds tab
        driver.findElement(By.xpath("//button[@title='Successful']")).click();

        /* Customized build number
        build_Num = input("Input the Build number:")
        driver.find_element_by_link_text("#"+build_Num).click()
        */
        // Get the section
        //temp_build = config_object['installation']['last_run_build']

        ////div[contains(@id,'artifacts')] - Artifact Icon

        // To get build number
        Thread.sleep(5000);
        String latestBuildNumber = driver.findElement(By.xpath("//div[contains(@class, 'Build__number')]/div/a")).getText().split("#")[1];
        LoggingHandler.log_info("Build Number => " + latestBuildNumber);

        String lastRunBuild = getRunValue("previouslyRunBuild");

        // New Build availability
        if (latestBuildNumber.equals(lastRunBuild)) {
            LoggingHandler.log_info("No new build found");
        } else {
            // Use latest build
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[contains(@class, 'Build__number')]/div/a")).click();

            String build_number_date = driver.findElement(By.xpath("//div[@class='selected']/span")).getText();
            LoggingHandler.log_info("Build Number and Generated date => " + build_number_date);

            driver.findElement(By.linkText("Artifactory-Artifacts")).click();

            driver.switchTo().frame((WebElement) driver.findElement(By.id("iframe")));
            WebElement frameEle = driver.findElement(By.xpath("//iframe[@style='width:100%; height:100%;']"));
            driver.switchTo().frame(frameEle);

            driver.findElement(By.linkText("Installer/")).click();

            driver.findElement(By.linkText("CitrixWorkspaceApp.exe")).click();

            do {
                Thread.sleep(25000);
                LoggingHandler.log_info("Downloading the build....");
            } while (!(new File(System.getProperty("user.dir") + "\\Builds\\CitrixWorkspaceApp.exe").exists()));

            LoggingHandler.log_info("Successfully Downloaded the build");

            //Write the build info to previously run json file
            setRunValue("previouslyRunBuild", latestBuildNumber);

        }
        driver.quit();

    }

    public static void deleteCWABuild() {

        File cwa_file = new File(System.getProperty("user.dir") + "\\Builds\\CitrixWorkspaceApp.exe");
        try {
            cwa_file.delete();
            Thread.sleep(2000);
            if (cwa_file.exists()) {
                Thread.sleep(10000);
                cwa_file.delete();
                if (cwa_file.exists())
                    throw new InterruptedException();
            }
            else {
                LoggingHandler.log_info("File deleted successfully");
                LoggingHandler.log_info("Completed the execution!!!!!!");
            }
        }
        catch (Exception ex) {
            LoggingHandler.log_error("Failed to delete the CWA Win build");
        }
    }

}
