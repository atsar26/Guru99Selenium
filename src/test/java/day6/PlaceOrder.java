package day6;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import resources.Base;

public class PlaceOrder extends Base {

	/**
	 * NOTE: Before running Day6 test, run Day5 test for new email and Pass So that
	 * it will able to add item to cart and Day5 and Day6 are dependent tests (Day5
	 * and then Day6)
	 */

	@Test
	public void checkoutAndPlaceOrder() throws Exception {

		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// Click on MyAccount
		By myAccount = By.linkText("MY ACCOUNT");
		driver.findElement(myAccount).click();
		Thread.sleep(1000);

		// Login into an account
		String username = "acd@gmail.com";
		String password = "acd@2222";

		By emailId = By.name("login[username]");
		driver.findElement(emailId).sendKeys(username);
		Thread.sleep(1000);

		By pass = By.id("pass");
		driver.findElement(pass).sendKeys(password);
		Thread.sleep(1000);

		By login = By.xpath("//*[@id='send2']/span/span");
		driver.findElement(login).click();
		Thread.sleep(1000);

		By myWishlist = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a");
		driver.findElement(myWishlist).click();
		Thread.sleep(1000);
		By addToCart = By.xpath("//*[@class='first last odd']/td[5]/div/button/span/span");
		driver.findElement(addToCart).click();
		Thread.sleep(1000);

		By proceedCheckout = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div/div[1]/ul/li/button/span/span");
		driver.findElement(proceedCheckout).click();
		Thread.sleep(1000);

		// ShippingInfo
		By address = By.id("billing:street1");
		driver.findElement(address).sendKeys("ABC");
		Thread.sleep(1000);

		By city = By.id("billing:city");
		driver.findElement(city).sendKeys("New York");
		Thread.sleep(1000);

		By state = By.id("billing:region_id");
		driver.findElement(state).click();
		driver.findElement(state).sendKeys(Keys.DOWN);
		driver.findElement(state).sendKeys(Keys.ENTER);
		Thread.sleep(1000);

		By pin = By.id("billing:postcode");
		driver.findElement(pin).sendKeys("542896");
		Thread.sleep(1000);

		By telephone = By.id("billing:telephone");
		driver.findElement(telephone).sendKeys("1234568");
		Thread.sleep(1000);

		By continueProcess = By.xpath("//*[@id=\"billing-buttons-container\"]/button");
		driver.findElement(continueProcess).click();
		Thread.sleep(1000);

		By continueToPay = By.xpath("//*[@id='shipping-method-buttons-container']/button/span/span");
		driver.findElement(continueToPay).click();
		Thread.sleep(1000);

		By selectPaymentMethod = By.xpath("//*[@id='dt_method_checkmo']/label");
		driver.findElement(selectPaymentMethod).click();
		Thread.sleep(1000);

		By continueToPayment = By.xpath("//*[@id='payment-buttons-container']/button");
		driver.findElement(continueToPayment).click();
		Thread.sleep(1000);

		By placeOrder = By.xpath("//*[@id='review-buttons-container']/button/span/span");
		driver.findElement(placeOrder).click();
		Thread.sleep(1000);

		By orderNumber = By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/p[1]/a");
		String OrderNo = driver.findElement(orderNumber).getText();
		System.out.println("Order number " + OrderNo + " is generated....!");
		Thread.sleep(1000);

	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}
