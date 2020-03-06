package webpages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class YTHomepage extends YTGeneric {

	@FindBy(name = "search_query")
	WebElement searchBar;
	
	@FindBy(xpath = "(//yt-icon[@id='icon'])[2]")
	WebElement trendingTab;

	//export to query page
	@FindBy(id = "video-title")
	WebElement firstLink;
	
	final String homeURL = "https://www.youtube.com/";
	
	public YTHomepage(WebDriver driver) {
		super(driver);
		driver.get(homeURL);
	}

	// conglomerates
	public void typeNewSearchTerm(String x) {
		focusSearchBar(); clearSearchBar(); typeInSearchBar(x); executeSearch();
	}

	// basic action tasks
	public void clickTrending() {
		trendingTab.click();
	}

	public void focusSearchBar() {
		searchBar.click();
	}

	public void clearSearchBar() {
		searchBar.clear();
	}

	public void typeInSearchBar(String x) {
		searchBar.sendKeys(x);
	}

	public void executeSearch() {
		searchBar.submit();
	}

	// return element information
	public String getFirstLink() {
		return firstLink.getAttribute("href");
	}
	
}