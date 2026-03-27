package stepDefinitions.login;

import io.cucumber.java.en.Given;

public class loginSteps {
    @Given("User is on login page")
    public void user_is_on_login_page(){
        System.out.println("opening browser");
    }
}
