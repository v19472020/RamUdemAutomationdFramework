package com.test.homepage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.PageActions.HomePage;
import com.test.BaseProperties.testBase;

public class AddNewAddress extends testBase
{
	 public static final Logger log = Logger.getLogger(AddNewAddress.class.getName());
	  //WebDriver driver;
	  HomePage AddNewAddress;
    @BeforeTest
    public void setup()
    {
 //		  System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
 //		  driver = new FirefoxDriver();
 //		  driver.get("http://automationpractice.com/index.php");
		  init();
		  AddNewAddress = new HomePage(driver);		  
		  AddNewAddress.LoginToApplication("ramesh.korla@gmail.com","test123");	
     }
	  @Test
     public void AddNewAddressTest() throws InterruptedException 
     {   
		  log.info("===== Starting Test =====");
		  AddNewAddress.AddNewAddress();
		  boolean Alert = false;
		  getScreenShot("AddNewAddressTest");
		  if(Alert)
		  {   
		  AssertJUnit.assertEquals(AddNewAddress.getAlertText(), "The alias HomeAddress has already been used. Please select another one.");
		  }else
		  {
			  AssertJUnit.assertEquals(AddNewAddress.getNewAddressMessage(), "MY ADDRESSES"); 
		  }
		  log.info("===== Finish Test =====");
     }
     @AfterClass    
     public void endTest() 
     {
   	  driver.quit();
     }

}
