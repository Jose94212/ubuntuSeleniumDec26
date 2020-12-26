package com.flipkart.testcases.login;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.flipkart.common.BaseTest;
import com.flipkart.commonpages.Login;

public class Init extends BaseTest{
	final static Logger log = Logger.getLogger(Init.class);
	
	Login objLogin;
	
	@BeforeClass
	public void beforeClass() {
		objLogin = new Login(driver);
	}
	
	@AfterClass
	public  void closeDriver() {
		driver.close();
		log.info("driver closed!!!");
	}
}
