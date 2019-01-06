package com.test.RegisterPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.PageActions.AccountPage;
import com.test.BaseProperties.waterToGoBase;

public class CopyandPasteTest extends waterToGoBase
{
	
	AccountPage account;
	@BeforeTest
	public void setup()
	{
		init();
	}
	@Test
	public void verifyTest() throws InterruptedException
	{
		  account = new AccountPage(driver);
	      driver.get("https://www.watertogo.eu/water-to-go-water-bottle-in-black-with-black-sleeve.html");
	      Actions ac= new Actions(driver);
	      ac.doubleClick(driver.findElement(By.xpath(".//*[@id='product-textual']/div[2]/div[1]"))).build().perform();
	      ac.keyDown(Keys.SHIFT).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.HOME).perform();   
	      ac.keyUp(Keys.SHIFT).sendKeys(Keys.CONTROL+"c").perform(); 
	      Thread.sleep(2000);
          ac.click(driver.findElement(By.xpath(".//*[@id='search']"))).perform();
	      try 
	      {
			Robot rb=new Robot();
			rb.keyPress(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);	
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
		  } catch (AWTException e) {
			e.printStackTrace();
		  }
	      ac.sendKeys(Keys.BACK_SPACE).perform();
	      Thread.sleep(6000);
	      driver.findElement(By.xpath(".//*[@id='search_mini_form']/div/button")).click();
	      Thread.sleep(12000);
	}
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}

	
}
