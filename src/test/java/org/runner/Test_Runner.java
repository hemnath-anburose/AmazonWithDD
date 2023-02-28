package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/resources/Features"},
			glue = {"org.definition", "org.hooks"},
			dryRun = false,
			monochrome = true,
			tags = ("@SC"),
//			plugin = {"pretty", "html:report/report.html"}
			plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class Test_Runner {

}
