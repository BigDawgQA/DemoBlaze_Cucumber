package stepsDefinitions;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

import java.util.Map;

public class CheckoutSteps {

    HomePage homePage = new HomePage(BaseClass.getDriver());
    ProductPage productPage = new ProductPage(BaseClass.getDriver());
    CartPage cartPage = new CartPage(BaseClass.getDriver());


    @When("user adds products to cart")
    public void user_adds_products_to_cart() {

        homePage.clickPhoneCategory();
        Assert.assertTrue(homePage.checkPhoneCategories());
        homePage.clickSamSungS6();


        Assert.assertTrue(productPage.isSamSungDisplayed());
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isProductAdded());
        productPage.navigateBack();


        homePage.clickLaptopsCategory();
        Assert.assertTrue((homePage.checkLaptopCategories()));
        homePage.clickDell2017();

        Assert.assertTrue(productPage.isDell2017Displayed());
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isProductAdded());
        productPage.navigateBack();

        homePage.clickMonitorsCategory();
        Assert.assertTrue((homePage.checkMonitorsCategories()));
        homePage.clickAppleMonitor();

        Assert.assertTrue(productPage.isAppleMonitorDisplayed());
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isProductAdded());
        productPage.navigateBack();

        homePage.clickCart();
    }

    @When("user proceed to checkout with details below:")
    public void user_proceed_to_checkout_with_details_below(DataTable dataTable) {

        cartPage.clickPlaceOrder();

        Map<String, String> checkOutDetails = dataTable.asMap();
        cartPage.setName_input(checkOutDetails.get("customerName"));
        cartPage.setCountry_input(checkOutDetails.get("country"));
        cartPage.setCity_input(checkOutDetails.get("city"));

        cartPage.setCreditCard_input(checkOutDetails.get("creditCard"));
        cartPage.setMonth_input(checkOutDetails.get("month"));
        cartPage.setYear_input(checkOutDetails.get("year"));

        cartPage.clickPurchaseButton();

    }

    @Then("checkout should be successful")
    public void checkout_should_be_successful() {

        Assert.assertTrue(cartPage.isThankYouPageDisplayed());
        cartPage.confirmPurchase();

    }

}
