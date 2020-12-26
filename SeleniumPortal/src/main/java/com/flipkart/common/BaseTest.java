package com.flipkart.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.flipkart.services.InitiateDriverBrowser;
import com.flipkart.services.ScreenShot;

public class BaseTest {

	public static final String URL = "https://flipkart.com";

	final static Logger log = Logger.getLogger(BaseTest.class);

	public WebDriver driver;
	public ScreenShot objScreenShot;

	@BeforeTest
	public void initiateDriverBrowser() {
		driver = InitiateDriverBrowser.initiateDriverBrowser("chrome", BaseTest.URL);
		objScreenShot = new ScreenShot(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		log.info("driver quit!!!");
	}

}
