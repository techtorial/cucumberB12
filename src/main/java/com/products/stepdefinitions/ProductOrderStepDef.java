package com.products.stepdefinitions;

import com.products.pages.ProductsLoginPage;
import com.products.pages.ProductsMainPage;
import com.products.pages.ProductsOrderPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class ProductOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    ProductsLoginPage loginPage=new ProductsLoginPage(driver);
    ProductsMainPage mainPage=new ProductsMainPage(driver);
    ProductsOrderPage orderPage=new ProductsOrderPage(driver);

    @Given("User navigates to product homepage and clicks Order Button")
    public void user_navigates_to_product_homepage_and_clicks_order_button() {
        driver.get(ConfigReader.readProperty("producturl"));
        loginPage.login(ConfigReader.readProperty("productusername"),ConfigReader.readProperty("productpassword"));
        mainPage.clickOrderButton();
    }

    @When("User enters the product information {string} and {string}")
    public void user_enters_the_product_information_and(String product, String quantity) {
        orderPage.sendProductInformation(product,quantity);
    }

    @When("User enters the address information {string},{string},{string},{string},{string}")
    public void user_enters_the_address_information(String name, String street, String city, String state, String zip) {
       orderPage.sendAddressInformation(name,street,city,state,zip);
    }

    @When("User enters the payment information {string},{string},{string} and process the order")
    public void user_enters_the_payment_information_and_process_the_order(String cardNumber, String expireDate, String cardType) {
        orderPage.sendPaymentInformation(cardNumber,expireDate,cardType);
    }

    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage,orderPage.getMessage());
    }
    @Then("User clicks View All Orders and validates {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_clicks_view_all_orders_and_validates(String name, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10) {

    }
}
