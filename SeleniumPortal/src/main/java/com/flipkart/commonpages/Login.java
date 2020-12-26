package com.flipkart.commonpages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.flipkart.common.BaseClass;

public class Login extends BaseClass {

	String xpathUserName = ".//form/div/input[@type=\"text\"]";
	String xpathPassword = ".//form/div/input[@type=\"password\"]";
	String xpathLogin = "(.//form/div/button[@type='submit'])[2]";

	public Login(WebDriver driver) {
		super(driver);
	}

	final static Logger log = Logger.getLogger(Login.class);

	public void login(String username, String password) {
		try {
			enterInput(By.xpath(xpathUserName), username);
			enterInput(By.xpath(xpathPassword), password);
			click(By.xpath(xpathLogin));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathLogin)));
		} catch (Exception e) {
			log.info(e);
		}
	}

}
