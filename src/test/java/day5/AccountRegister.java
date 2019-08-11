package day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;

public class AccountRegister extends Base {

	@Test
	public void newAccountRegistration() throws Exception {

		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);

		// Click on MyAccount
		//// *[@id="top"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a
		By myAccount = By.linkText("MY ACCOUNT");
		driver.findElement(myAccount).click();
		Thread.sleep(1000);

		// Click on Create an Account
		By createAccount = By.xpath("//a[@title='Create an Account']");
		driver.findElement(createAccount).click();
		Thread.sleep(1000);

		// Account registration

		By firstname = By.id("firstname");
		driver.findElement(firstname).sendKeys("Abhavsa2");

		By lastname = By.id("lastname");
		driver.findElement(lastname).sendKeys("AbLastName2");

		By email = By.id("email_address");
		driver.findElement(email).sendKeys("xyz@rediffmail.com");
		Thread.sleep(1000);

		By pass = By.id("password");
		driver.findElement(pass).sendKeys("ab@1222");

		By confirmPass = By.id("confirmation");
		driver.findElement(confirmPass).sendKeys("ab@1222");
		Thread.sleep(1000);

		By registerButton = By.xpath("//*[@id='form-validate']/div[2]/button/span/span");
		driver.findElement(registerButton).click();
		Thread.sleep(2000);

		System.out.println("****Account registration Complete....!***");

		// Click on TV
		HomePage h = new HomePage(driver);
		h.tv().click();
		Thread.sleep(2000);

		By addWishlist = By.xpath("*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a");
		driver.findElement(addWishlist).click();
		Thread.sleep(2000);

		By shareWishlist = By.xpath("//*[@id='wishlist-view-form']/div/div/button[1]/span/span");
		driver.findElement(shareWishlist).click();
		Thread.sleep(2000);

		By emailId = By.cssSelector("#email_address");
		driver.findElement(emailId).sendKeys("abxx@rediffmail.com");

		By message = By.cssSelector("#message");
		driver.findElement(message).sendKeys("Message on Share WishLish is displayed...");

		By shareWishlistButton = By.xpath("//*[@id='form-validate']/div[2]/button");
		driver.findElement(shareWishlistButton).click();
		Thread.sleep(2000);
	}

	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	  }
	
}
