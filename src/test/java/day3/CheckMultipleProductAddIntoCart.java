package day3;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import resources.Base;


public class CheckMultipleProductAddIntoCart extends Base {

	@Test
	public void checkProductaAddToCart() throws Exception {

		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		// 1. get Url
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		HomePage h = new HomePage(driver);
		h.mobile().click();

		By addToCart = By.xpath("//button[@title='Add to Cart']");
		// driver.findElement(addToCart).clear();;
		driver.findElement(addToCart).click();

		By quantity = By.xpath("//input[@title='Qty']");
		driver.findElement(quantity).clear();
		driver.findElement(quantity).sendKeys("1000");

		By updateButton = By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button/span/span");
		driver.findElement(updateButton).click();

		By error = By.cssSelector("p[class='item-msg error']");
		String errorMessage = driver.findElement(error).getText();

		try {
			assertEquals(errorMessage, "The requested quantity for \"Sony Xperia\" is not available");
		} catch (Exception e) {
		}

		By emptyCart = By.xpath("//*[@id='empty_cart_button']/span/span");
		driver.findElement(emptyCart).click();

		By textEmptyCart = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div[1]/h1");
		String textEmpCart = driver.findElement(textEmptyCart).getText();

		try {
			assertEquals(textEmpCart, "SHOPPING CART IS EMPTY");
		} catch (Exception e) {
		}

	}

	@AfterClass
	public void tearDown() throws Exception{
		Thread.sleep(3000);
		driver.quit();
	}

}
