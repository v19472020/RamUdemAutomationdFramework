package com.test.homepage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.slf4j.LoggerFactory;

import com.test.PageActions.HomePage;
import com.test.BaseProperties.testBase;

public class TC001_verifyLoginwithInvalidCendential extends testBase
{
	 public static final Logger log = Logger.getLogger(TC001_verifyLoginwithInvalidCendential.class.getName());
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
//    	  driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
//    	  Thread.sleep(4000);
//    	  driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("test@gmail.com");
//    	  driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("password");
//    	  driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
//    	  Thread.sleep(4000);
		  // Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='center_column']/div[1]/ol/li")).getText(), "Authentication failed." );
	      log.info("===== Starting Test =====");
		  homepage = new HomePage(driver);	
		  log.info("Execute the Script");
		  homepage.LoginToApplication(emailAddress,password);	
    	  Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
    	 log.info("===== Finish Test =====");
      }
      @AfterClass    
      public void endTest() 
      {
    	  driver.quit();
      }
}
