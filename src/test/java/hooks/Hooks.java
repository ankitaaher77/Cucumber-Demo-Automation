package hooks;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentManager;

public class Hooks extends BaseTest {
    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Before
    public void setUp(Scenario scenario) {
        initializeDriver();
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            String screenshotPath = takeScreenshot(scenario.getName());

            test.fail("Test Failed")
                    .addScreenCaptureFromPath(screenshotPath);

        } else {
            test.pass("Test Passed");
        }

        extent.flush();
        quitDriver();
    }
}