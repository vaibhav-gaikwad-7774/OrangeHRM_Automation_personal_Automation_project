package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(css = "button[type ='submit']")
	WebElement loginButton;
	 
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement profile;
	
	@FindBy(linkText = "Logout")
	WebElement logoutlink;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void login(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		loginButton.click();
		
		
	}
	
	public void logout() {
		profile.click();
		logoutlink.click();
	}
	
	public boolean isProfileDisplay() {
		return profile.isDisplayed();
	}
	
}
