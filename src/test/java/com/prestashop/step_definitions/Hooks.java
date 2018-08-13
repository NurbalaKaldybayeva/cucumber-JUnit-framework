package com.prestashop.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.prestashop.utilities.ConfigurationReader;
import com.prestashop.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	//this class is separate because it does not effect on main scenario
	//this class for setting up and closing and it works independent

	@Before
	public void setUp(){
		System.out.println("running before each scenario");
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().fullscreen();
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}
	
//	@Before()
//	public void setUpAmazon(){
//		System.out.println("running before each scenario");
//		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Driver.getDriver().manage().window().fullscreen();
//		Driver.getDriver().get("http://amazon.com");
//	}
	
	  @After
	  public void tearDown(Scenario scenario) {
	    // only takes a screenshot if the scenario fails
	    if (scenario.isFailed()) {
	      // taking a screenshot
	      final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
	          .getScreenshotAs(OutputType.BYTES);
	      // adding the screenshot to the report
	      scenario.embed(screenshot, "image/png");
	    }
	    Driver.closeDriver();
	  }
}
