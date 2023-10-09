package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
//
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(
//		features = {".//Features/Customer.feature",".//Features/Login.feature"},
		features = ".//Features/Login.feature",
		glue = "StepDefination",
		dryRun=false,
		monochrome=true,
		tags="@sanity"
//		plugin = {"pretty","html:target/cucumber-reports/reports_html.html"}
		)

public class Runner extends AbstractTestNGCucumberTests{
	
	
}

