package com.weborder.stepdefinitions;

import com.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderLoginStepDef {
    WebDriver driver;
    @Given("User navigates to the WebOrder")
    public void user_navigates_to_the_web_order() {
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("weborderurl"));
    }

    @When("User provides correct {string} and {string} for WebOrder")
    public void user_provides_correct_and_for_web_order(String userName, String password) {
        WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);
        loginPage.webOrderLogin(userName,password);
    }

    @Then("User validates the {string} from homepage")
    public void user_validates_the_from_homepage(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
        driver.quit();
    }

}
