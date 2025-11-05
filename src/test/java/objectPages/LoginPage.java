package objectPages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver ldriver;
	
	JavascriptExecutor executor;
	WebDriverWait wait40;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		this.executor = (JavascriptExecutor) this.ldriver;
		
		this.wait40 = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		
		PageFactory.initElements(rdriver, this);
	}
	
	//City Search
	@FindBy(xpath="//*[@id=\"dummy\"]")
	WebElement firstwindow;
	
	
	
	@FindBy (xpath="//input[@placeholder='Search for your city']")
	WebElement city;
	
	//sign in button on home page
	@FindBy(xpath="//*[@id=\"super-container\"]/div[1]/div[1]/div/div/div/div[2]/div[2]/div[1]/div")
	WebElement SignInButton;
	
	//findby exmail id
	@FindBy(id="emailid")
	WebElement EmailidInput;
	
	
	
}
