package resources;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {
	
	
	public  static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws Exception {
		
		prop = new Properties();
		String filePath = "D:\\Bhavana\\data.properties";
		FileInputStream fis = new FileInputStream(filePath);

		prop.load(fis);
	
		String browserName = prop.getProperty("browser");
		
		//for Google Chrome 
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Bhavana\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		//for Firefox 
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.firefox.marionette", "D:\\Bhavana\\geckodriver.exe");
			//firefox
			driver = new FirefoxDriver();
		}
		
		//for Internet Explore
		else if(browserName.equals("IE")){
			System.setProperty("webdriver.ie.driver", "D:\\Bhavana\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		//Wait after initiating driver
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		return driver;
	}

	
	
	

}
