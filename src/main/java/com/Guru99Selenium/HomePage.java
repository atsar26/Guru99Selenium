package com.Guru99Selenium;

import org.testng.annotations.Test;

import resources.Base;

public class HomePage extends Base {
	
	
	public void getURL() throws Exception{
		driver= initializeDriver();
		driver.get(prop.getProperty("URL"));
		
	}
	
	
	
	

}
