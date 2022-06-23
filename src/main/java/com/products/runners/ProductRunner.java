package com.products.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //Karate.class
@CucumberOptions(
        features = "src/main/resources/features/products",
        glue = "com/products/stepdefinitions",
        dryRun = false,
        tags ="@product",
        plugin ={"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)

public class ProductRunner {
}
