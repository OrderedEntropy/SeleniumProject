package utility;

import java.lang.reflect.Constructor;

import org.openqa.selenium.WebDriver;

import webpages.*;

@Deprecated
public class PomReplacement {
	@SuppressWarnings("rawtypes")
	public static <E> E changePOM(YTGeneric fromPage, String URL, Class<E> type) {
		if (type != null) {
			WebDriver driver;
			if(fromPage == null)
				driver = DriverSingleton.getDriver();
			else
				driver = fromPage.getDriver();
			driver.get(URL);
			System.out.print(type);
			Constructor[] cs = type.getConstructors();
			for (int i = 0; i < cs.length; i++) {
				try {
					return type.cast(cs[i].newInstance(driver));
				} catch (Exception e) {
					continue;
				}
			}
		}
		return null;
	}
}
