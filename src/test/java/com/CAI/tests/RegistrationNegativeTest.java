package com.CAI.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CAI.generic.AutoConstant;
import com.CAI.generic.BaseTest;
import com.CAI.generic.ExcelData;
import com.CAI.generic.ListenerTest;
import com.CAI.pages.RegNegPage;
import com.CAI.pages.RegistrationPage;
import com.relevantcodes.extentreports.LogStatus;
@Listeners(ListenerTest.class)
public class RegistrationNegativeTest extends BaseTest implements AutoConstant
{
	String exp="Thank you for registering with SAP Conversational AI" ;
	
	//Method used to verify the Registration feature by entering Invalid values
	@Test(dataProvider="regdatanegative")
	public void registrationNegativeTest(String fn,String ln,String email,String pwd,String repwd) throws InterruptedException
	{
		
		
			
			//RegistrationPage rp = new RegistrationPage(driver);
			
			RegNegPage rp=new RegNegPage(driver);
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
			
		

			
	}
		//This method allows us to pass the multiple values to a single test in single execution using TestNG Data-provider annotation
		@DataProvider(name="regdatanegative")
		public String[][] getRegData() throws Exception
		{
			int rs=ExcelData.getRowSize(negregpath,"sheet1");
			int cs = ExcelData.columnSize(negregpath, 1,"sheet1");
			System.out.println(rs+"\n"+cs);
			
			
			String[][] reg=new String[rs][cs];
			
			for(int i=1;i<=rs;i++)
			{
				for(int j=0;j<cs;j++)
				{
				reg[i-1][j]=ExcelData.getData(negregpath, i, j,"sheet1");
				}
			}
			return reg;
			
		}
	

}
