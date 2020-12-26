package com.flipkart.services;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomMethods {

	final static Logger log = Logger.getLogger(CustomMethods.class);

	WebDriver driver;
	public WebDriverWait wait;

	public CustomMethods(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public WebElement waitByVisibility(By by) {
		try {
			log.info("waiting for " + by);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (TimeoutException e) {
			log.debug(e);
			return null;
		} catch (NoSuchElementException e) {
			log.debug(e);
			return null;
		} catch (Exception e) {
			log.debug(e);
			return null;
		}

	}

	public void enterInput(By by, String inputValue) {
		try {
			waitByVisibility(by).sendKeys(inputValue);
			log.info("value entered:" + inputValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.debug(e);
		}
	}

	public WebElement findElement(By by) {
		try {
			return driver.findElement(by);
		} catch (Exception e) {
			log.debug(e);
			return null;
		}
	}

	public void click(By by) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
			log.info("clicked on:" + by);
		} catch (Exception e) { 
			log.debug(e);
		}
	}
}
