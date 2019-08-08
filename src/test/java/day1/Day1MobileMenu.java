package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import resources.Base;

public class Day1MobileMenu extends Base {
	
	
	@Test
	public void MobileSortByName() throws Exception {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		driver.get("http://live.guru99.com/index.php/");
		//get Url
		
		//verify title
		
		//WebElement title_Home=driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div/h2/text()"));
		//title_Home.getText().contains("THIS IS DEMO SITE");
		String actual_title= driver.getTitle();
		String expected_title="THIS IS DEMO  SITE";
		
		if(actual_title.equalsIgnoreCase(expected_title))
		{
			System.out.println("title matched");
		}
		else
		{
			System.out.println("title not matched");
		}
		
		//click on MOBILE
		
		driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
		//verify title
		
		String act_title=driver.getTitle();
		String exp_title="MOBILE";
		if(act_title.equalsIgnoreCase(exp_title))
		{
			System.out.println("title matched");
		}
		else
		{
			System.out.println("title not matched");
		}
		//Sort by name
		
		Select s= new Select(driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		s.selectByVisibleText("Name");
	
		
	}
	
	
	
	

}
