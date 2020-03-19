package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.DriverSingleton;

public class YTLogin extends YTGeneric{
	
	@FindBy(id = "identifierId")
	WebElement usernameField;
	
	@FindBy(xpath = "//div[@id='identifierNext']/span/span")
	WebElement usernameButton;

	@FindBy(name = "password")
	WebElement passField;
	
	@FindBy(xpath = "//div[@id='passwordNext']/span")
	WebElement passButton;
	
	public YTLogin(WebDriver driver, boolean fromHomePage) {
		super(driver);
		if(fromHomePage) {
			new YTHomepage(DriverSingleton.getDriver()).pressLogin();
		}
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String user){
		usernameField.click();
		usernameField.clear();
		usernameField.sendKeys(user);
	}
	
	public void submitUser() {
		usernameButton.click();
	}

	public void enterPass(String pass){
		passField.click();
		passField.clear();
		passField.sendKeys(pass);
	}
	
	public void submitPass() {
		passButton.click();
	}
}
