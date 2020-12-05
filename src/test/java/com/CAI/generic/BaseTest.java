package com.CAI.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	public ExtentReports reports;
	public ExtentTest etest;
	
	@BeforeClass
	public void startReport()
	{
	reports =	new ExtentReports(System.getProperty("user.dir")+ "\\Extentrreport.html");
		
		etest = reports.startTest("RegTests");
	
		
	}
	
	
	@BeforeMethod
	public void openBrowser()
	{
		System.setProperty(chromekey,chromevalue);
		driver = new ChromeDriver();
		driver.get("https://cai.tools.sap/");
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		
	}
	@AfterClass
	public void  endreport() 
	{
		reports.endTest(etest);
		reports.flush();
	}
}
