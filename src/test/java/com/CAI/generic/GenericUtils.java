package com.CAI.generic;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils
{
	
	public static void switchToFrame(WebDriver ldriver,String id,int time) 
	{	

		WebDriverWait wait=new WebDriverWait(ldriver, time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}
	
	public static void explcitWait(WebDriver ldriver,WebElement ele, String action,int time )
	{
		WebDriverWait wait=new WebDriverWait(ldriver, time);
		if(action.equals("clickable"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
		else if(action.equals("visibility"))
		{
		
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[contains(@id,'ids-heading-1')]")));
			
		}
		else if(action.equals("vis"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text()='Thank you for registering with SAP Conversational AI']")));
		}
		
	}

}