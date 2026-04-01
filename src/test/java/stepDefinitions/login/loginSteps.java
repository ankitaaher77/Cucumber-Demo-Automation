package stepDefinitions.login;

import Pages.LoginPage;
import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class loginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("opening browser");
        driver.get("https://currituck-staging.tekark.com/login");
        loginPage = new LoginPage(driver);
    }
    @When("User enters email ID and password")
    public void user_enters_search_text() {
        driver.findElement(By.xpath("//input[@placeholder=\"Enter Email Address\"]")).sendKeys("biba@yopmail.com");
        driver.findElement(By.xpath("//input[@placeholder=\"Enter Password\"]")).sendKeys("Test@123");
    }

    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//button[@class=\"btn-htc btn-medium\"]")).click();

  try{
            Thread.sleep(2000);
        } catch (Exception e) {}
    }
    @Then("User should navigate to blind page")
    public void user_should_blind_location() {
        String actualTitle = driver.getTitle();
        System.out.println("We get a Title As:" + actualTitle);

        Assert.assertTrue(actualTitle.contains("Users"),
                "Login failed - Users page not visible");
    }
}








