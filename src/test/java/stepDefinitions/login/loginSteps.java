package stepDefinitions.login;

import Pages.LoginPage;
import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.Assert;
import utils.JsonReader;

public class loginSteps extends BaseTest {
    private static final String LOGIN_URL = "https://currituck-staging.tekark.com/login";
    private static final String TEST_EMAIL = "biba@yopmail.com";
    private static final String TEST_PASSWORD = "Test@123";

    LoginPage loginPage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        System.out.println("opening browser");
        driver.get(LOGIN_URL);
        loginPage = new LoginPage(driver);
    }

    @When("User enters {string} and {string}")
    public void user_enters_credentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLogin();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("User should navigate to Users page")
    public void user_should_navigate_to_Users_page() {
        String actualTitle = driver.getTitle();
        System.out.println("We get a Title As:" + actualTitle);

        Assert.assertTrue(actualTitle.contains("Users"),
                "Login failed - Users page not visible");
    }
}







