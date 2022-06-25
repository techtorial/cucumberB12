package com.products.stepdefinitions;

import com.products.pages.ProductsLoginPage;
import com.products.pages.ProductsMainPage;
import com.products.pages.ProductsOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

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
    public void user_clicks_view_all_orders_and_validates(String name, String product, String quantity, String street,
                                                          String city, String state, String zipcode, String cardtype, String cardNumber,
                                                          String expirationDate) {
        mainPage.clickViewAllOrderButton();
        mainPage.validateTheInformationFromTable(name,product,quantity,street,city,state,zipcode,cardtype,cardNumber,expirationDate);
    }


    @Given("User navigates to product homepage and clicks Order Button with DataTable")
    public void user_navigates_to_product_homepage_and_clicks_order_button_with_data_table(DataTable dataTable) {
        driver.get(ConfigReader.readProperty("producturl"));
//        Map<String,String> loginCredentials=dataTable.asMap();//username=Tester,password=test
//        loginPage.login(loginCredentials.get("username"),loginCredentials.get("password"));
        List<String> credentials=dataTable.asList();
        loginPage.login(credentials.get(0),credentials.get(1));
        mainPage.clickOrderButton();
    }

    @When("User enters the product information")
    public void user_enters_the_product_information(DataTable dataTable) {
        Map<String,String> productInformation=dataTable.asMap();
        orderPage.sendProductInformation(productInformation.get("product"),
                                         productInformation.get("quantity"));
    }

    @When("User enters the address information")
    public void user_enters_the_address_information(DataTable dataTable) {
        Map<String,String> addressInformation=dataTable.asMap();
        orderPage.sendAddressInformation(addressInformation.get("name"),
                                         addressInformation.get("street"),
                                         addressInformation.get("city"),
                                         addressInformation.get("state"),
                                         addressInformation.get("zipCode"));
    }

    @When("User enters the payment information and process the order")
    public void user_enters_the_payment_information_and_process_the_order(DataTable dataTable) {
        Map<String,String> paymentInformation=dataTable.asMap();
        orderPage.sendPaymentInformation( paymentInformation.get("cardNumber"),
                                         paymentInformation.get("expireDate"),
                                           paymentInformation.get("cardType"));

    }

    @Then("User validates the message")
    public void user_validates_the_message(DataTable dataTable) {
        List<String> message=dataTable.asList();
        Assert.assertEquals(message.get(0),orderPage.getMessage());
    }

    @Then("User clicks View All Orders and validates")
    public void user_clicks_view_all_orders_and_validates(DataTable dataTable) {


        //HOMEWORK

        //you can either go with LIST or MAP for this task

    }
}
