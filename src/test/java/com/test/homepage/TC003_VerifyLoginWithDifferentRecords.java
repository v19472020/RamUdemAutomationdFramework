package com.test.homepage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.PageActions.HomePage;
import com.test.BaseProperties.testBase;

public class TC003_VerifyLoginWithDifferentRecords extends testBase
{
	public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());
	HomePage homepage;	
	//String emailAddress = "ramesh.korla@gamil.com";
//	String password = "test123";
	@DataProvider(name="loginData")
	public String[][] getTestData()
	{
		String[][] testRecords = getData("TestData.xlsx","LoginTestData");
		return testRecords;
	}	
	@BeforeClass
	public void setUp()
	{
		init();
	}
	@Test(dataProvider="loginData")
	public void LoginTest(String emailAddress, String password, String runMode)
	{
		log.info("**** Start Login Test***");
		homepage = new HomePage(driver);
		homepage.LoginToApplication(emailAddress, password);
		boolean status = homepage.verifyLogoutDisplay();
		getScreenShot("LoginTest"+emailAddress);	
		if(status)
		{
			homepage.clickonlogout();
		}
		AssertJUnit.assertEquals(status, true);
		log.info("**** Finished Login Test***");
	}
	@AfterClass
	public void endTest()
	{
		driver.close();
	}
}
