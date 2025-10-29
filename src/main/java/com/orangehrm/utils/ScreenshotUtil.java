package com.orangehrm.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {
	public static String captureScreenshot(WebDriver driver, String testName) {
		String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		String path = "Screenshots/" + testName + " " + timestamp + ".png";
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest = new File(path);
		
		try {
			FileHandler.copy(src, dest);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
