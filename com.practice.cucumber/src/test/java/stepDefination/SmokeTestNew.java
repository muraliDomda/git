package stepDefination;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import Pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProviders.ConfigFileReader;

public class SmokeTestNew {

	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	ConfigFileReader configFileReader;

	@Before("@ui")
	public void setup() throws Throwable {
		configFileReader = new ConfigFileReader();
		configFileReader.getDriverPath();
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}

	@Given("^Open firefox and start application$")
	public void Open_firefox_and_start_application() throws Throwable {
		driver.get(configFileReader.getApplicationUrl());
	}

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void I_enter_valid_username_and_valid_password(String uname, String pass) throws Throwable {
		lp.login(uname, pass);
	}

	@Then("^user should be able to login successfully$")
	public void user_should_be_able_to_login_successfully() throws Throwable {
		Assert.assertTrue("not displayed", hp.isHomepageSearchBootonExists().equals(true));
	}

	@Then("^application should be closed$")
	public void application_should_be_closed() throws Throwable {
		driver.close();
	}

	@After("@ui")
	public void tearDown() throws Throwable {
		driver.quit();
	}

}
