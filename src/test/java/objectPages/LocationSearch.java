package objectPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LocationSearch {
	
	WebDriver ldriver;
	
	public LocationSearch(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	


}
