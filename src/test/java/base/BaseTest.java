package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    public void initializeDriver() {
        WebDriverManager.chromedriver().setup(); // auto setup driver
        driver = new ChromeDriver();             // launch browser
        driver.manage().window().maximize();     // maximize window
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit(); // close browser
        }
    }
}
