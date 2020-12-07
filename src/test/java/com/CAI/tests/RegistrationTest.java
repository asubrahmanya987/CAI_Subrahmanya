package com.CAI.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CAI.generic.AutoConstant;
import com.CAI.generic.BaseTest;
import com.CAI.generic.ExcelData;
import com.CAI.pages.RegistrationPage;
import com.relevantcodes.extentreports.LogStatus;
public class RegistrationTest extends BaseTest implements AutoConstant
{
	String exp="Thank you for registering with SAP Conversational AI" ;
	
	//Method used to verify the Registration feature by entering valid values
	@Test(dataProvider="regdata")
	public void registrationPositiveTest(String fn,String ln,String email,String pwd,String repwd) throws InterruptedException
	{
		
		try {
			
			RegistrationPage rp = new RegistrationPage(driver);
			
			
			rp.Registrationclick();
			etest.log(LogStatus.PASS, "Clicked Sigh up button");
			rp.EnterFirstname(fn);
			etest.log(LogStatus.PASS, "Entered First name");
			rp.EnterLastname(ln);
			etest.log(LogStatus.PASS, "Entered Last name");
			rp.EnterEmail(email);
			etest.log(LogStatus.PASS, "Entered Email");
			rp.EnterPassword(pwd);
			etest.log(LogStatus.PASS, "Enetered Password");
			rp.ConfirmPassword(repwd);
			etest.log(LogStatus.PASS, "Renetered password");
			rp.ClickPrivacy();
			etest.log(LogStatus.PASS, "Clicked Privacy");
			rp.Clickterms();
			etest.log(LogStatus.PASS, "Clicked terms");
			rp.ClickRegister();	
			etest.log(LogStatus.PASS, "Clicked Register");
			rp.assertRegStatus(exp);
			etest.log(LogStatus.PASS, "Registered successfully");
			
		} catch (Exception e)
		{
			etest.log(LogStatus.FAIL, e.getMessage());
			
		}
		
			
	}
		//This method allows us to pass the multiple values to a single test in single execution using TestNG Dataprovider annotation
		@DataProvider(name="regdata")
		public String[][] getRegData() throws Exception
		{
			int rs=ExcelData.getRowSize(path);
			int cs = ExcelData.columnSize(path, 1);
			
			String[][] reg=new String[rs][cs];
			
			for(int i=1;i<=rs;i++)
			{
				for(int j=0;j<cs;j++)
				{
				reg[i-1][j]=ExcelData.getData(path, i, j);
				}
			}
			return reg;
			
		}
	

}
