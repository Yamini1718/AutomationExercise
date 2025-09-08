package com.automationexercise.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/feature/Product.feature"},
    glue = {"com.automationexercise.stepdefinitions"},
    		plugin = {
    			    "pretty",
    			    "html:target/cucumber-reports",
    			    "json:target/cucumber-reports/cucumber.json",
    			    "junit:target/cucumber-reports/cucumber.xml"
    			},

    monochrome = true
)
public class TestRunner { }
