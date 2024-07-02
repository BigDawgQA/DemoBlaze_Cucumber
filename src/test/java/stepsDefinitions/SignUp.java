package stepsDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;

import java.io.IOException;
import java.util.Properties;

public class SignUp {

    private Properties p;
    private HomePage homePage = new HomePage(BaseClass.getDriver());


    @Given("User clicks Sign up")
    public void user_clicks_sign_up() throws InterruptedException {

        homePage.click_signUp();
    }

    @When("user provides username: {string} and password : {string}")
    public void user_Provides_Username_And_Password(String username, String password) {

        username = BaseClass.randomAlphaNumeric();
        password = BaseClass.randomAlphaNumeric();
        homePage.setSignupUsername(username);
        homePage.setSignupPassword(password);

    }

    @When("user provides already used username: {string} and password : {string}")
    public void userProvidesAlreadyusedUsernameAndPassword(String username, String password) throws IOException {

        p = BaseClass.getProperties();
        username = p.getProperty("alreadyUsedUsername");
        password = p.getProperty("password");
        homePage.setSignupUsername(username);
        homePage.setSignupPassword(password);

    }

    @When("user click Sign up")
    public void user_click_sign_up() {

        homePage.clickCompleteSignUp();
    }

    @Then("alert is displayed with Sign up successful.")
    public void alert_is_displayed_with_sign_up_successful() {

        //Assert.assertFalse(homePage.doesUsernameExists());
        Assert.assertTrue(homePage.isSignUpSuccessful());
    }


    @Then("alert is displayed and sign up is not successful.")
    public void alertIsDisplayedAndSignUpIsNotSuccessful() {

        Assert.assertTrue(homePage.doesUsernameExists());
    }
}
