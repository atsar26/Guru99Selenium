package day1;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.Base;

public class Day1MobileMenu extends Base {
	
	
	@Test
	public void MobileSortByName() throws Exception {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		//1. get Url
		driver.get("http://live.guru99.com");
		
		//2. verify Home page title
		String homePage= driver.getTitle();
		assertEquals(homePage, "Home page");

		//3. Check Text on Home page
		String text = driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div/h2")).getText();
		assertEquals(text.trim(), "THIS IS DEMO SITE FOR");
		
		
		//4. verify Mobile page title
		HomePage l = new HomePage(driver);
		l.mobile().click();
		String mobileTitle= driver.getTitle();
		assertEquals(mobileTitle, "Mobile");
		
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		//5. Sort by Name 
		WebElement sortBy = driver.findElement(By.xpath("//select[@title='Sort By']"));
		Select s= new Select(sortBy);
		s.selectByVisibleText("Name");
	
		//6. Take Screenshots
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File ("E://sc.png"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.quit();
	}
}
