package com.hf.tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hf.pageObjects.AddCustomerPage;
import com.hf.pageObjects.HomePage;
import com.hf.pageObjects.LoginPage;
import com.hf.utilities.XLUtils;

public class TC_AddCustomer_004 extends BaseClass{
	
	@Test(dataProvider = "AddCustomer")
	public void addCustomer(String cname, String cgender, String mm, String dd, String yy, String caddress, String ccity, String cstate,
			String cpinno, String ctelephoneno, String cemailid, String cpassword) {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickSubmit();
		
		HomePage hp = new HomePage(driver);
		hp.clickNewCustomerLink();
		
		AddCustomerPage ac = new AddCustomerPage(driver);
		ac.custName(cname);
		ac.custgender(cgender);
		ac.custdobmm(mm);
		ac.custdobdd(dd);
		ac.custdobyy(yy);
		ac.custaddress(caddress);
		ac.custcity(ccity);
		ac.custstate(cstate);
		ac.custpinno(cpinno);
		ac.custtelephoneno(ctelephoneno);
		ac.custemailid(cemailid);
		ac.custsubmit();
		
	}
	
	
	@DataProvider(name="AddCustomer")
	String[][] getData() throws IOException{
		String path = System.getProperty("user.dir")+"/src/test/java/com/hf/testData/AddCustomer.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String[][] custdata = new String[rownum][colcount];
		for(int i = 1; i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				custdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return custdata;
	}

}
