package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
	
	// export this to a data/settings file
	final static String driverPath = "C:\\Program Files\\chromedriver_win32\\chromedriver.exe";
	final static String sysDriverName = "webdriver.chrome.driver";
	final static int secondsToWait = 30;
	
	private static WebDriver driver;
	
	public static WebDriver getDriver(){
		if(driver == null) {
			System.setProperty(sysDriverName, driverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(secondsToWait, TimeUnit.SECONDS);
		}
		return driver;
	}

	public static void closeDriver() {
		if(driver != null)
			driver.quit();
		driver = null;
	}
	
}
