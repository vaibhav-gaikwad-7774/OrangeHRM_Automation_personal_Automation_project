package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.orangehrm.utils.ScreenshotUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static ExtentTest logger;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/orangehrm/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	public static void initialization() {

		String browserName = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browserName.equals("chrome")) {

			driver = new ChromeDriver();

			driver.manage().window().maximize();

		} else if (browserName.equals("firefox")) {

			driver = new FirefoxDriver();

			driver.manage().window().maximize();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get(prop.getProperty("url"));

	}

	protected void logWithScreenshot(String message) {
		String testName = message.replace(" ", "_");
		String path = ScreenshotUtil.captureScreenshot(driver, testName);

		if (logger != null) {
			logger.log(Status.INFO, message);

			logger.info("🖼️ Click to Open Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(path).build());

		} else {
			System.out.println("⚠️ Logger is null. Screenshot saved at: " + path);
		}
	}

	@AfterMethod

	public void tearDown() {

		driver.quit();
	}

}
