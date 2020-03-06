package hellocucumber;

import io.cucumber.java.en.*;
import utility.DriverSingleton;
import webpages.*;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stepdefs {

	// export this to a data/settings file
	String url = "https://www.youtube.com/";
	
	private static YTHomepage homepage;
	private static YTQuery querypage;
	private static YTVideo videopage;

	private String expected;
	private String actual;

	// test data, port out to some test file
	private String darkMode = "true";
	private String trendingPage = "https://www.youtube.com/feed/trending";
	private String videoLanding = "https://www.youtube.com/watch?v=";

	@Given("I am on homepage")
	public void i_am_on_homepage() {
		homepage = new YTHomepage(DriverSingleton.getDriver());
	}

	@Given("settings focused")
	public void settings_focused() {
		homepage.openSettings();
		homepage.openDarkModeTab();
	}

	@When("I toggle dark mode")
	public void i_toggle_dark_mode() {
		homepage.clickDarkMode();
	}

	@Then("I should be displayed dark mode")
	public void i_should_be_displayed_dark_mode() {
		actual = homepage.isDarkMode();
		expected = darkMode;
		assertEquals(expected, actual);
	}

	@When("I click trending")
	public void i_click_trending() {
		homepage.clickTrending();
	}

	@Then("I should be taken to trending page")
	public void i_should_be_taken_to_trending_page() {
		actual = DriverSingleton.getDriver().getCurrentUrl();
		expected = trendingPage;
		assertEquals(expected, actual);
	}

	@Given("I type into the searchbar {string}")
	public void i_type_into_the_searchbar(String string) {
		homepage.focusSearchBar();
		homepage.clearSearchBar();
		homepage.typeInSearchBar(string);
	}

	@When("I click search")
	public void i_click_search() {
		homepage.executeSearch();
	}

	@Then("I should find the {string}")
	public void i_should_find_the(String string) {
		actual = homepage.getFirstLink();
		expected = videoLanding + string;
		assertEquals(expected, actual);
	}

	public static void deletePOMs() {
		homepage = null;
		querypage = null;
		videopage = null;
	}
	
}
