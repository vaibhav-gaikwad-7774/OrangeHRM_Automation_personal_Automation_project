package com.orangehrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath = "//aside[@class='oxd-sidepanel']//li[1]\")")
	public WebElement adminMenu;
	
	@FindBy(xpath = "//aside[@class='oxd-sidepanel']//li")
	List<WebElement> leftMenuOptions;

	@FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
	WebElement usernameField;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]")
	WebElement userRoleDropdown;

	@FindBy(xpath = "(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]")
	WebElement userStatusDropdown;

	@FindBy(css = "button[type='submit']")
	WebElement searchButton;

	@FindBy(xpath = "//div[@class='oxd-table-card']/div")
	List<WebElement> resultRows;
	
	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public int getMenuOptionCount() {
		return leftMenuOptions.size();
		
	}
	
	
	public int searchByUserName(String uname) throws InterruptedException{
		usernameField.clear();
		usernameField.sendKeys(uname);
		searchButton.click();
		Thread.sleep(2000);
		return resultRows.size();
	}
	
	public int searchByUserRole(String role) throws InterruptedException{
		userRoleDropdown.click();
		WebElement statusOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@role='option']/span[text()='\" + role + \"']")));
		statusOption.click();
		searchButton.click();
		Thread.sleep(2000);
		
		return resultRows.size();
		
	}
	
	public int searchByUserStatus(String status)throws InterruptedException{
		userStatusDropdown.click();
		
		WebElement statusOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@role='option']/span[text()='\" + status + \"']")));
		statusOption.click();
		searchButton.click();
		
		
		return resultRows.size();
	}
	
	
	
	public int getDisplayedRecordCountFromText() {
		String recordsText = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span"))
				.getText();
		String[] split = recordsText.split("[()]");
		return Integer.parseInt(split[1]);
		
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
