package hellocucumber;

import io.cucumber.junit.CucumberOptions;
import utility.DriverSingleton;
import io.cucumber.junit.Cucumber;

import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, strict = true)
public class RunCucumberTest {
  @BeforeClass
  public static void setup() {
	  DriverSingleton.getDriver();
  }

  @Before
  public static void setupEach() {
	  Stepdefs.deletePOMs();
  }

  @After
  public static void teardownEach() {
	  DriverSingleton.getDriver().manage().deleteAllCookies();
  }
  
  @AfterClass
  public static void teardown() {
     DriverSingleton.closeDriver();
  }
}
