package stepsDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.HomePage;

import java.io.IOException;
import java.util.Properties;

public class sendContactMessageSteps {

    private final HomePage homePage = new HomePage(BaseClass.getDriver());
    private Properties p;


    @Given("User clicks Contact")
    public void user_clicks_contact() {

        homePage.clickContact();
    }

    @When("user input email, name and message")
    public void user_input_email_name_and_message() throws IOException {

        p = BaseClass.getProperties();
        homePage.setContact_email_input(p.getProperty("contact_email"));
        homePage.setContact_name_input(p.getProperty("customerName"));
        homePage.setMessage_input(p.getProperty("message"));
    }

    @When("user click send message")
    public void user_click_send_message() {

        homePage.clickSendMessage();
    }

    @Then("Thanks for the message!! should be displayed")
    public void thanks_for_the_message_should_be_displayed() {

        Assert.assertTrue(homePage.isMessageSent());
    }

}
