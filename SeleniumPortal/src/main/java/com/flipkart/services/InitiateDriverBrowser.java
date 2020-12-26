package com.flipkart.services;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitiateDriverBrowser {
	final static Logger log = Logger.getLogger(InitiateDriverBrowser.class);
	static WebDriver driver;

	/**
	 * @param browser
	 * @param url
	 * @return
	 */
	public static WebDriver initiateDriverBrowser(String browser, String url) {
		try {
			if (browser.toLowerCase().contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
				driver = new ChromeDriver();
				log.info("initialized driver and browser:" + browser);
				driver.get(url);
				log.info("fetched url:" + url);
				driver.manage().window().maximize();
				log.info("maximized window");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			}
			return driver;
		} catch (Exception e) {
			log.debug(e);
			return null;
		}
	}

}
