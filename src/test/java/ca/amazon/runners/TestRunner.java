package ca.amazon.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\shiva\\eclipse-workspace\\amazon\\src\\test\\resources\\ca\\amazon\\features",
		glue= {"ca.amazon.stepdefinitions","ca.amazon.apphooks"},
        plugin= {
		"pretty","json:target/HTMLReport.json"
		}
		)

public class TestRunner {

}
