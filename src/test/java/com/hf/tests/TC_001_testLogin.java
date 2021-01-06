package com.hf.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hf.pageObjects.LoginPage;

public class TC_001_testLogin extends BaseClass {

	@Test
	public void testLoginfeature() throws IOException {

		logger.info("URL is opened");
		driver.manage().window().maximize();
		logger.info("Chrome is maximised");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();
		logger.info("Clicked on the Submit button");
		String title = driver.getTitle();
		System.out.println(title);

		if (title.equals("GTPL Bank Manager HomePage123")) {
			Assert.assertTrue(false);
			logger.info("Test case passed");
		} else {
			captureScreen(driver, "testLoginfeature");
			Assert.assertTrue(true);
			logger.info("Test case failed");
		}

	}

}
