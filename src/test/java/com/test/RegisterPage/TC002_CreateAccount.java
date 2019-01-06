package com.test.RegisterPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.BaseProperties.testBase;
import com.test.PageActions.AccountPage;

public class TC002_CreateAccount extends testBase {
	
	AccountPage Ap;
	
	@BeforeTest
	public void browserSetup()
	{
		init();
	}
	 @Parameters({"Firstname","Lastname","Email","password","confirmpassword"})
    @Test
    public void verifyCreateAccount(String Firstname, String Lastname, String Email, String password, String confirmpassword )
    {
    	Ap = new AccountPage(driver);
    	Ap.CreateAccountValidate(Firstname, Lastname, Email, password, confirmpassword);
    	
    }
}
