package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentTest logger;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/orangehrm/config/config.properties");

			try {
				prop.load(ip);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void intiitalization() {
		String browsername = System.getProperty("browser")!=null ? System.getProperty("browser")
				: prop.getProperty("browser");
		
		if (browsername.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		}
		else if(browsername.equals("Safari")) {
			driver = new SafariDriver();
			driver.manage().window().maximize();
		}
			
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		
		
	}
	
	protected void logicWithScreenshot(String message) {
		String testName = message.replace(" ", "_");
		String path = ScreenshotUtil.captureScreenshot(driver, testName);
	}
	
	
	
	
	
	
}
















