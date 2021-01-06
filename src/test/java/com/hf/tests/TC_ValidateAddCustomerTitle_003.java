package com.hf.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hf.pageObjects.HomePage;
import com.hf.pageObjects.LoginPage;

public class TC_ValidateAddCustomerTitle_003 extends BaseClass {

	@Test
	public void testAddCustomerTitle() throws IOException {
		
		logger.info("URL is opened");
		driver.manage().window().maximize();
		logger.info("Chrome is maximised");
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.setUserName(userName);
		logger.info("Username is entered");
		lp.setPassword(password);
		logger.info("Password is entered");
		lp.clickSubmit();
		logger.info("Clicked on the Submit button");
		hp.clickNewCustomerLink();
		String title = driver.getTitle();
		logger.info(title);
		/*
		 * if (title.equals("Gtpl Bank New Customer Entry Page")) {
		 * Assert.assertTrue(true); logger.info("Test case passed"); } else {
		 * captureScreen(driver, "testAddCustomerTitle"); Assert.assertTrue(false);
		 * logger.info("Test case failed"); }
		 */

	}
}
