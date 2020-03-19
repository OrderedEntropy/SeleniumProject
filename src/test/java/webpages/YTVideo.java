package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YTVideo extends YTGeneric {
	private static final String videoLanding = "https://www.youtube.com/watch?v=";
	private static final String pausedString = "paused-mode";
	private static final String playingString = "playing-mode";
	private static final String mutedString = "muted";
	private static final char LKeyChar = 'l';

	@FindBy(xpath = "//*[@id=\"container\"]/h1/yt-formatted-string")
	WebElement videoName;

	@FindBy(xpath = "//*[@id=\"info\"]/div[1]")
	WebElement videoUnavail;

	@FindBy(xpath = "//*[@id=\"movie_player\"]")
	WebElement videoPlayer;
	
	@FindBy(xpath = "//div[@id='movie_player']/div[24]/div[2]/div/span/button")
	WebElement muteButton;

	@FindBy(xpath = "//*[@id=\"movie_player\"]/div[24]/div[2]/div[1]/span/div")
	WebElement volumeLevel;
	
	@FindBy(xpath = "//div[@id='info-contents']/ytd-video-primary-info-renderer")
	WebElement videoFrame;
	
	@FindBy(xpath = "//div[@id='movie_player']/div[16]/a")
	WebElement replayButton;
	
	public YTVideo(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public YTVideo(WebDriver driver, String url) {
		super(driver);
		driver.get(videoLanding + url);
		PageFactory.initElements(driver, this);
	}

	public void togglePlayMode() {
		videoPlayer.sendKeys(" ");
	}

	public void toggleMute() {
		muteButton.click();
	}
	
	public void focusVideoFrame() {
		videoFrame.click();
	}
	
	public void skipTenSeconds() {
		videoPlayer.sendKeys(Character.toString(LKeyChar));
	}
	
	public void skipVideo(int x) {
		focusVideoFrame();
		for(int i = 0; i < x; i++) {
			skipTenSeconds();
		}
	}
	
	public void clickReplayButton() {
		replayButton.click();
	}
	
	public boolean isMuted() {
		System.out.print(volumeLevel.getText());
		return volumeLevel.getAttribute("aria-valuetext").contains(mutedString);
	}

	public boolean isPlaying() {
		return videoPlayer.getAttribute("class").contains(playingString);
	}

	public boolean isPaused() {
		return videoPlayer.getAttribute("class").contains(pausedString);
	}

	public String getVideoName() {
		return videoName.getText();
	}

	public boolean videoUnavailable() {
		return videoUnavail.isDisplayed();
	}

}
