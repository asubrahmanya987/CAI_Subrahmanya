package com.CAI.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class croseeBrowserTest
{

	
	String chromekey = "webdriver.chrome.driver";
	String chromevalue = "E:\\driver\\chromedriver.exe";
	
	WebDriver driver ;
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty(chromekey, chromevalue);
			 driver = new ChromeDriver();
			driver.get("https://www.facebook.com");
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty(chromekey, chromevalue);
	 driver = new ChromeDriver();
			driver.get("https://www.google.com");	
		}
	}
	@Test
	public void crossbrowsertest()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}
	
	@AfterClass
	public void afterTest()
	{
		driver.close();
	}
}
