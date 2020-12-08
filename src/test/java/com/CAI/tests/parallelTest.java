package com.CAI.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelTest
{
	String chromekey = "webdriver.chrome.driver";
String chromevalue = "E:\\driver\\chromedriver.exe";
	
	@Test
	public void method1()
	{
		System.setProperty(chromekey, chromevalue);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
	}
	@Test
	public void method2() 
	{
		System.setProperty(chromekey, chromevalue);
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		
	}

}
