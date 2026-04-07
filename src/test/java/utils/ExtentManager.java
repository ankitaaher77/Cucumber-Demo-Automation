package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

import static base.BaseTest.driver;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String path = System.getProperty("user.dir") + "/src/test/resources/reports/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(path);
            spark.config().setReportName("Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }

    public String takeScreenshot(String testName) {

        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/target/screenshots/" + testName + ".png";

            File destination = new File(path);
            destination.getParentFile().mkdirs(); // create folder if not exist

            Files.copy(source.toPath(), destination.toPath());

            return path;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

