package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement userName;
	@FindBy(id = "pass")
	private WebElement pasword;
	@FindBy(id = "loginbutton")
	private WebElement loginButton;

	public void login(String username, String Password) {
		userName.sendKeys(username);
		pasword.sendKeys(Password);
		loginButton.click();
	}

}
