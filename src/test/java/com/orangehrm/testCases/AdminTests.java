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
	AdminPage adminPage;
	ExtentReports report;

	@BeforeMethod
	public void setup() {
		initialization();
		login = new LoginPage(driver);
		adminPage = new AdminPage(driver);
		login.login("Admin", "admin123");
		adminPage.adminMenu.click();

	}

	@Test(priority = 1)
	public void verifyMenuCount() {
		System.out.println(adminPage.getMenuOptionsCount());
		Assert.assertEquals(adminPage.getMenuOptionsCount(), 12);
	}

	@Test(priority = 2)
	public void searchByUsername() throws InterruptedException {

		int result = adminPage.searchByUserName("Admin");

		logWithScreenshot("Records found by searching with user name - Admin");

		System.out.println("Result by searching with username " + result);

		Assert.assertEquals(result, adminPage.getDisplayedRecordCountFromText());

		adminPage.refreshPage();
	}

	@Test(priority = 3)
	public void searchByUserRole() throws InterruptedException {

		int result = adminPage.searchByUserRole("Admin");

		logWithScreenshot("Records found by searching with role- Admin");

		System.out.println("Result by searching with user role " + result);

		Assert.assertEquals(result, adminPage.getDisplayedRecordCountFromText());

		adminPage.refreshPage();
	}

	@Test(priority = 4)
	public void searchByStatus() throws InterruptedException {

		int result = adminPage.searchByUserStatus("Enabled");

		logWithScreenshot("Records found by searching with status- Enabled");

		System.out.println("Result by searching with status " + result);

		Assert.assertEquals(result, adminPage.getDisplayedRecordCountFromText());

		adminPage.refreshPage();
	}

}
