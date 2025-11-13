package com.ws.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/LoginPage.feature"} ,
                 glue = {"com.ws.stepdefinition","com.ws.hooks"},
                 dryRun=false,
                 plugin = {"pretty",
                         "json:target/reports/report.json",
                         "json:target/reports/report.xml",
                         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},publish = true)
public class TestRunner {
}
