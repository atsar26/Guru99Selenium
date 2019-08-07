package day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import resources.Base;

public class Day1MobileMenu extends Base {
	
	
	@Test
	public void MobileSortByName() throws Exception {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		

		//get URL
		//click on MOBILE
		//verify title
		//Sort by name
		//verify title
		
	}
	
	
	
	

}
