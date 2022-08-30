package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_HRMS_application() {
        openBrowser();
    }

    @When("user enters valid admin username and password")
        public void user_enters_valid_admin_username_and_password() {

            sendKeys(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));
            sendKeys(loginPage.passwordTextField, ConfigReader.getPropertyValue("password"));
        }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
       click(loginPage.loginButton);
    }


    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        System.out.println("successfully logged in");

    }



        }




