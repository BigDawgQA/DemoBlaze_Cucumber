package stepsDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

public class LoginSteps {

    private HomePage homePage = new HomePage(BaseClass.getDriver());
    private LoginPage loginPage = new LoginPage(BaseClass.getDriver());

    @Given("user is on the Demo blaze landing page")
    public void user_is_on_the_demo_blaze_landing_page() {

        Assert.assertTrue(homePage.checkHomePageImages());

    }
    @Given("User clicks Log in")
    public void user_clicks_log_in() {

        homePage.clickLoginButton();
    }

    @When("user input username: {string} and password : {string}")
    public void user_input_username_and_password(String username, String password) {

        homePage.setLogin_username_input(username);
        homePage.setLogin_password_input(password);
    }

    @When("user click login")
    public void user_click_login() {

        homePage.clickCompleteLoginButton();
    }

    @Then("user should have access to the product page")
    public void user_should_have_access_to_the_product_page() {

        Assert.assertTrue(loginPage.isLoginSuccessful());
    }


    @Then("validate the page should not have broken links")
    public void broken_links_should_be_or_less_than() throws IOException {

        int count = 0;
        LinkedList<String> listHref = homePage.getHrefValues();

        for(String links: listHref){

            URL linkUrl = new URL(links);
            HttpURLConnection connection = (HttpURLConnection) linkUrl.openConnection();
            connection.connect();

            if(connection.getResponseCode() >=400){
                count++;
            }
        }
        Assert.assertEquals(0, count);
    }


}
