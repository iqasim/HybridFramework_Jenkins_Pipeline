package com.hf.tests;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hf.pageObjects.HomePage;
import com.hf.pageObjects.LoginPage;
import com.hf.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String username, String pwd) {
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.setUserName(username);
		logger.info("Username is entered");
		lp.setPassword(pwd);
		logger.info("Password is entered");
		lp.clickSubmit();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Test case failed");
			Assert.assertTrue(false);
		}else {
			Assert.assertTrue(true);
			logger.info("Test case Passed");
			hp.clickLogout();
			logger.info("Clicked on Log out");
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
		driver.switchTo().alert();
		return true;
		}catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/hf/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] logindata = new String[rownum][colcount];
		for(int i = 1; i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
