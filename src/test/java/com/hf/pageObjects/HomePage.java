package com.hf.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[text()='Log out']")
	WebElement logout;
	
	@CacheLookup
	@FindBy(how=How.XPATH, using="//a[text()='New Customer']")
	WebElement newcustomerlink;
	
	
	
	public void clickLogout() {
		logout.click();
	}
	
	public void clickNewCustomerLink() {
		newcustomerlink.click();
	}

}
