package com.products.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class ProductsMainPage {

    public ProductsMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//a[.='Order']" )
    WebElement orderButton;

    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrdersButton;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")//13 elements
    List<WebElement> allInformation;

    public void clickOrderButton(){
        orderButton.click();
    }

    public void clickViewAllOrderButton(){
        viewAllOrdersButton.click();
    }

    public void validateTheInformationFromTable(String name,String productName,String quantity,String street
    ,String city,String state,String zipCode,String cardType,String cardNumber,String expirationDate){
        Assert.assertEquals(name,allInformation.get(1).getText().trim());
        Assert.assertEquals(productName,allInformation.get(2).getText().trim());
        Assert.assertEquals(quantity, BrowserUtils.getText(allInformation.get(3)));
        Assert.assertEquals(street, BrowserUtils.getText(allInformation.get(5)));
        Assert.assertEquals(city, BrowserUtils.getText(allInformation.get(6)));
        Assert.assertEquals(state, BrowserUtils.getText(allInformation.get(7)));
        Assert.assertEquals(zipCode, BrowserUtils.getText(allInformation.get(8)));
        Assert.assertEquals(cardType, BrowserUtils.getText(allInformation.get(9)));
        Assert.assertEquals(cardNumber, BrowserUtils.getText(allInformation.get(10)));
        Assert.assertEquals(expirationDate, BrowserUtils.getText(allInformation.get(11)));
    }
}
