package com.orangehrm.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.orangehrm.base.TestBase;
import com.orangehrm.pages.AdminPage;
import com.orangehrm.pages.LoginPage;

public class AdminTests extends TestBase {
	LoginPage login;
	AdminPage adminpage;
	ExtentReports report;
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		login = new LoginPage(driver);
		login.login("Admin", "admin123");
		adminpage.adminMenu.click(); 
	}
	
	
	@Test(priority = 1)
	public void varifyMenyCount() {
		System.out.println(adminpage.getMenuOptionCount());
		Assert.assertEquals(adminpage.getMenuOptionCount(), 12);
	}
	
	
	
	@BeforeMethod
	public void tearDown() {
		driver.close();
	}
	
}
