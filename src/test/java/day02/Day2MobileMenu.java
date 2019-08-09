package day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class Day2MobileMenu extends Base {
	
	@Test
	public void MobileCheckCost() throws Exception {
	driver = initializeDriver();
	driver.get(prop.getProperty("URL"));
	//1. get Url
	driver.get("http://live.guru99.com");
	
	//Click on mobile menu
	HomePage l = new HomePage(driver);
	l.mobile().click();
	
	WebElement cost=driver.findElement(By.xpath("//span[@ id='product-price-1']"));
	String c=cost.getText();
	System.out.println(c);
	
	//click on sony xperia
	driver.findElement(By.xpath("//a[@ title='Sony Xperia']")).click();
	
	WebElement co=driver.findElement(By.cssSelector("span.price"));
	String cc=co.getText();
	System.out.println(cc);
	Assert.assertEquals(c, cc);
	/*if(c.equalsIgnoreCase(cc))
	{
		System.out.println("same");
	}
	else
	{
		System.out.println("not same");
	}*/
	
	}
	

}
