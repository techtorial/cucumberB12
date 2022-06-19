package com.weborder.stepdefinitions;

import com.weborder.pages.WebOrderLoginPage;
import com.weborder.pages.WebOrderPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class WebOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderPage orderPage=new WebOrderPage(driver);

    @When("User clicks Group Order Box and Next Button")
    public void use_clicks_group_order_box_and_next_button() {
    orderPage.clickTheButtons();
    }


}
