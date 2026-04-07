package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BaseTest {
    public static WebDriver driver;

    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
    public String takeScreenshot(String testName) {

        {

            try {
                File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                String path = System.getProperty("user.dir")
                        + "/src/test/resources/reports/screenshots/"
                        + testName + ".png";

                File destination = new File(path);
                destination.getParentFile().mkdirs();

                Files.copy(source.toPath(), destination.toPath(),
                        StandardCopyOption.REPLACE_EXISTING); // ✅ FIX

                return path;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        }
        }


