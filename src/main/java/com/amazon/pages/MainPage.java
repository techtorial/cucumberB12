package com.amazon.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {

    /*
    1-Navigate to the amazon website
    2-Search for iphone 13 case
    3-Validate the number is 40000
    4-Validate all header has "iPhone"
     */
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchField;

    @FindBy(xpath = "//span[contains(text(),'of over')]")
    WebElement results;

    @FindBy(xpath = "//h2//a")
    List<WebElement> allHeader;

    public void searchWord(String search){
        searchField.sendKeys(search, Keys.ENTER);
    }

    public int resultOfSearch(){
        String [] result=results.getText().trim().split(" ");
         int lastResult=Integer.parseInt(result[3].replace(",",""));//40000
        return lastResult;
    }

    public void validateHeaders(String word){
        for(WebElement header:allHeader){
            if(!BrowserUtils.getText(header).equals("")){
                Assert.assertTrue(BrowserUtils.getText(header).contains(word));
            }
        }
    }

}
