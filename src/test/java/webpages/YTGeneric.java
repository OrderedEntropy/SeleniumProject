package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YTGeneric {
	WebDriver driver;
	
	@FindBy(xpath = "(//button[@id='button']/yt-icon)[7]")
	WebElement settings;

	@FindBy(xpath = "//div[@id='items']/ytd-toggle-theme-compact-link-renderer")
	WebElement darkModeTab;

	@FindBy(id = "toggleButton")
	WebElement darkModeButton;
	
	@FindBy(xpath = "//html")
	WebElement htmlProperties;
	
	public YTGeneric(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// conglomerates
	public void enableDarkMode() {
		openSettings();
		openDarkModeTab();
		clickDarkMode();
	}
	
	// basic action tasks
	public void openSettings() {
		settings.click();
	}

	public void openDarkModeTab() {
		darkModeTab.click();
	}

	public void clickDarkMode() {
		darkModeButton.click();
	}
	
	// return element information
	public WebDriver getDriver() {
		return driver;
	}
	
	public String isDarkMode() {
		return htmlProperties.getAttribute("dark");
	}
}
