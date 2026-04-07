package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='Enter Email Address']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@placeholder='Enter Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn-htc btn-medium']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String emailId) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(emailId);
    }

    public void enterPassword(String pass) {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        passwordInput.clear();
        passwordInput.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }
    
    public void loginAs(String emailId, String pass) {
        enterEmail(emailId);
        enterPassword(pass);
        clickLogin();
    }
}
