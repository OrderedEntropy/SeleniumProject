package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.DriverSingleton;

public class YTQuery extends YTGeneric {
	public YTQuery(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

//	https://www.youtube.com/results?search_query=hi
	// *[@id="contents"]

	@FindBy(xpath = "(//yt-icon[@id='contents'])")
	WebElement trendingTab;

	public static void main(String[] args) {
		WebDriver driver = DriverSingleton.getDriver();
	}

}

//
//@FindBy(name = "search_query")
//WebElement searchBar;
////export to query page
//@FindBy(id = "video-title")
//WebElement firstLink;
//
//final String homeURL = "https://www.youtube.com/";
//
//public YTHomepage(WebDriver driver) {
//	super(driver);
//	driver.get(homeURL);
//}
//
//// conglomerates
//public void typeNewSearchTerm(String x) {
//	focusSearchBar(); clearSearchBar(); typeInSearchBar(x); executeSearch();
//}
//
//// basic action tasks
//public void clickTrending() {
//	trendingTab.click();
//}
//
//public void focusSearchBar() {
//	searchBar.click();
//}
//
//public void clearSearchBar() {
//	searchBar.clear();
//}
//
//public void typeInSearchBar(String x) {
//	searchBar.sendKeys(x);
//}
//
//public void executeSearch() {
//	searchBar.submit();
//}
//
//// return element information
//public String getFirstLink() {
//	return firstLink.getAttribute("href");
//}