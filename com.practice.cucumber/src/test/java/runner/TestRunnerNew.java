package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import dataProviders.ConfigFileReader;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features/test2.feature", glue = "stepDefination", plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-html-report/report.html",
		"html:target/cucumber-html-report", "json:target/cucumber.json" }, monochrome = true)
public class TestRunnerNew {

	@AfterClass
	public static void writeExtentReport() {
		ConfigFileReader configFileReader = new ConfigFileReader();
		Reporter.loadXMLConfig(configFileReader.getReportConfigPath());
	}
}