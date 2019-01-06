package com.test.homepage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.BaseProperties.testBase;
import com.test.PageActions.HomePage;

public class TC006_VerifyLoginwithValiddata extends testBase{
	
	 public static final Logger log = Logger.getLogger(TC006_VerifyLoginwithValiddata.class.getName());
	  //WebDriver driver;
	 HomePage homepage;
    @BeforeTest
    public void setup()
    {
//		  System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
//		  driver = new FirefoxDriver();
//		  driver.get("http://automationpractice.com/index.php");
		  init();    	  
     }
     @Parameters({"emailAddress","password"})
	  @Test
     public void verifyLoginwithInvalidCendential(String emailAddress, String password) 
     {

	      log.info("===== Starting Test =====");
		  homepage = new HomePage(driver);	
		  log.info("Execute the Script");
		  homepage.LoginToApplication(emailAddress,password);	
   	 // Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
   	 log.info("===== Finish Test =====");
     }
     @AfterClass    
     public void endTest() 
     {
   	  driver.quit();
     }

}
