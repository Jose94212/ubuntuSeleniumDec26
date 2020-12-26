package com.flipkart.testcases.login;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class TestLogin extends Init {

	/* Get actual class name to be printed on */
	final static Logger log = Logger.getLogger(TestLogin.class);

	@Test
	public void login() {
		objLogin.login("usernarm", "password@");
		objScreenShot.takeScreenShot("loginSuccess");
		log.info("logged in!!!");
		System.out.println("");
	}

}
