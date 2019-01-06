package com.test.homepage;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.PageActions.HomePage;
import com.test.BaseProperties.testBase;

public class TC005_CreateAccountwithXLFile extends testBase {

	public static final Logger log = Logger.getLogger(TC005_CreateAccountwithXLFile.class.getName());
	HomePage Hp;	

	@DataProvider(name="CreateAccountData")
	public String[][] getTestData()
	{
		String[][] testRecords = getData("CreateAccount.xlsx","CreateAccountData");
		return testRecords;
	}	
	@BeforeClass
	public void setUp()
	{
		init();
	}
	@Test(dataProvider="CreateAccountData")
	public void createAccountTest(String email, String FirstName, String LastName, String pswd, String Date, String Month, String Year,
			String FirstName1, String LastName1, String Company, String Address1, String Address2, String City, String States, String PostCode,
			String Mobile_No, String Alias) throws InterruptedException
	{
		Hp = new HomePage(driver);
		log.info("Start the Create Account Test");
		Hp.AccountCreation(email, FirstName, LastName, pswd, Date, Month, Year, FirstName1, LastName1, Company, Address1, Address2, City, States, PostCode, Mobile_No, Alias);
		log.info("End the Create Account Test");
	}
}
