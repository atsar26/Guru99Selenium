package day4;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class CompareMobileProducts extends Base{
	
	@Test
	public void compareProducts() throws Exception {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		HomePage h = new HomePage(driver);
		h.mobile().click();
		
		By addToCartSonyExp = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a");
		driver.findElement(addToCartSonyExp).click();
		
		By addToCartIphone = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a");
		driver.findElement(addToCartIphone).click();
		
		By compareProducts = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button");
		driver.findElement(compareProducts).click();
		
		
		Set<String> set =  driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		
		String parentWindowId = itr.next();
		String childWindowId = itr.next();
		
		// Switch to Pop-up..
		driver.switchTo().window(childWindowId);
		System.out.println("Pop Compare window title: "+driver.getTitle());
		
		driver.manage().window().maximize();
        Thread.sleep(3000);	
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title: "+driver.getTitle());
		
	}

}
