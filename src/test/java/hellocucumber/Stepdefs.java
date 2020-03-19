package hellocucumber;

import io.cucumber.java.en.*;
import utility.DriverSingleton;
import webpages.*;

import static org.junit.Assert.*;

public class Stepdefs {

	// export this to a data/settings file
	String url = "https://www.youtube.com/";

	private static YTHomepage homepage;
	private static YTQuery querypage;
	private static YTVideo videopage;
	private static YTLogin loginpage;

	private String expected;
	private String actual;

	// test data, port out to some test file
	private String darkMode = "true";
	private String trendingPage = "https://www.youtube.com/feed/trending";
	private String videoLanding = "https://www.youtube.com/watch?v=";
	private String testVidLink = "YK6zVrlMFNs";

	public void waitOneSecond() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

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

	@Given("I type in a {string}")
	public void i_type_in_a(String string) {
		videopage = new YTVideo(DriverSingleton.getDriver(), string);
	}

	@Then("I should be taken {string}")
	public void i_should_be_taken(String string) {
		actual = videopage.getVideoName();
		expected = string;
		assertEquals(expected, actual);
	}

	@Then("I should be taken video unavailable page")
	public void i_should_be_taken_video_unavailable_page() {
		assertTrue(videopage.videoUnavailable());
	}

	@Given("I am on a video page")
	public void i_am_on_a_video_page() {
		videopage = new YTVideo(DriverSingleton.getDriver(), testVidLink);
	}

	@When("I press pause")
	public void i_press_pause() {
		videopage.togglePlayMode();

	}

	@And("wait for load")
	public void wait_for_load() {
		for (int i = 0; i < 2; i++) {
			waitOneSecond();
		}
	}

	@Then("the video pauses")
	public void the_video_pauses() {
		assertTrue(videopage.isPaused());
	}

	@When("I press mute")
	public void i_press_mute() {
		videopage.toggleMute();
	}

	@Then("the video mutes")
	public void the_video_mutes() {
		assertTrue(videopage.isMuted());
	}

	@Given("I am on login page")
	public void i_am_on_login_page() {
		loginpage = new YTLogin(DriverSingleton.getDriver(), true);
	}

	@When("I type in user {string}")
	public void i_type_in(String string) {
		loginpage.enterUsername(string);
	}

	@When("press submit user")
	public void press_submit_user() {
		loginpage.submitUser();
	}

	@When("type pass {string}")
	public void type(String string) {
		loginpage.enterPass(string);
	}

	@When("press submit pass")
	public void press_submit_pass() {
		loginpage.submitPass();
	}
	
	@Then("I log in {string}")
	public void i_log_in(String username) {
		assertTrue(loginpage.loginEmailCheck(username));
	}

	@Given("I finish watching video")
	public void i_finish_watching_video() {
		videopage.skipVideo(20);
	}

	@When("I click replay")
	public void i_click_replay() {
		videopage.clickReplayButton();
	}

	@Then("the video plays again")
	public void the_video_plays_again() {
		assertTrue(videopage.isPlaying());
	}

	public static void deletePOMs() {
		homepage = null;
		querypage = null;
		videopage = null;
		loginpage = null;
	}

}
