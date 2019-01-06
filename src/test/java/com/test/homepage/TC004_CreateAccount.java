package com.test.homepage;

import org.apache.log4j.Logger;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.PageActions.HomePage;
import com.test.BaseProperties.testBase;

public class TC004_CreateAccount extends testBase {

	public static Logger log = Logger.getLogger(TC004_CreateAccount.class.getName());
	
	HomePage Hp;
	
	@BeforeTest
	public void setUp()
	{
		init();
	}
	@Parameters({"eamil","FirstName","LastName","pswd","Date","Month","Year","FirstName1","LastName1","Company",
		"Address1", "Address2","City","States","PostCode","Mobile_No","Alias"})
	@Test
	public void createAccountTest(String email, String FirstName, String LastName, String pswd, String Date, String Month, String Year,
			String FirstName1, String LastName1, String Company, String Address1, String Address2, String City, String States, String PostCode,
			String Mobile_No, String Alias) throws InterruptedException
	{
		Hp = new HomePage(driver);
		log.info("Execution Starts:");
		Hp.AccountCreation(email, FirstName, LastName, pswd, Date, Month, Year, FirstName1, LastName1, Company, Address1, Address2, City, States, PostCode, Mobile_No, Alias);
		log.info("Execution Ends:");
	}
	



}
