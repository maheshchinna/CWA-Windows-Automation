package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import utilities.PropertiesFile;
import utilities.WinAppDriverSetUp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BuildDownloadSetUp extends PropertiesFile {

    @BeforeSuite
    void downloadCWABuild_setUp() throws IOException, InterruptedException {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir")+"\\Builds");
        prefs.put("safebrowsing.enabled",true);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);

        String branch=read_properties("branch");
        String build_url = "https://ftltc01.eng.citrite.net/viewType.html?buildTypeId=RfWin_" + branch + "_ICAClientCore";
        driver.get(build_url);

        driver.findElement(By.linkText("Log in as guest")).click();
        String title= driver.getTitle();
        // assert branch in loaded_page_title
        System.out.println("Branch => "+ title);

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
        String latestBuildNumber = driver.findElement(By.xpath("//div[@class='Build__number--ER']/div/a/span/span/span")).getText().split("#")[1];
        System.out.println("Build Number => "+ latestBuildNumber);

        String lastRunBuild=read_properties("previouslyRunBuild");

        if(latestBuildNumber.equals(lastRunBuild)) {
            System.out.println("No new build found");
        }
        else{
            // Use latest build
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@class='Build__number--ER']/div/a")).click();

            String build_number_date = driver.findElement(By.xpath("//div[@class='selected']/span")).getText();
            System.out.println("Build Number and Generated date => " + build_number_date);

            driver.findElement(By.linkText("Artifactory-Artifacts")).click();

            driver.switchTo().frame((WebElement) driver.findElement(By.id("iframe")));
            WebElement frameEle = driver.findElement(By.xpath("//iframe[@style='width:100%; height:100%;']"));
            driver.switchTo().frame(frameEle);

            driver.findElement(By.linkText("Installer/")).click();

            driver.findElement(By.linkText("CitrixWorkspaceApp.exe")).click();

            do {
                Thread.sleep(25000);
                System.out.println("Downloading the build....");
            }while(!(new File(System.getProperty("user.dir")+"\\Builds\\CitrixWorkspaceApp.exe").exists()));

            System.out.println("Successfully Downloaded the build");

            write_properties("previouslyRunBuild",latestBuildNumber);

        }
        driver.quit();

        // Enabling Dev mode and installing Win App Driver
        WinAppDriverSetUp.envSetUp();
    }


}
