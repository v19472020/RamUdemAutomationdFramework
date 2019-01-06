package com.test.RegisterPage;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.PageActions.AccountPage;
import com.test.BaseProperties.waterToGoBase;

public class TC001_CreateAccount extends waterToGoBase
{
    AccountPage account;
	
	@BeforeTest
	public void setup()
	{
		init();
	}
	@Test
	public void CreateAccountTest() throws InterruptedException
	{
		account = new AccountPage(driver);
		Thread.sleep(2000);
		account.CreateAccount();
		Thread.sleep(2000);
		//getScreenShot("CreateAccountTest");
	}	
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}

}
