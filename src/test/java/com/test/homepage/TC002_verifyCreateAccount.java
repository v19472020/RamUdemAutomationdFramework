package com.test.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.PageActions.HomePage;
import com.test.BaseProperties.testBase;

public class TC002_verifyCreateAccount extends testBase
{
//private WebDriverWait wait;
	HomePage homepage;
	@BeforeTest
    public void setup()
    {
        init();
    }
	  @Test
    public void TC002_verifyCreateAccount() throws InterruptedException 
    { 	  
		  homepage = new HomePage(driver); 
		  homepage.CreateAccount();
		  Assert.assertEquals(homepage.getAccountCreateMessage(), "Welcome to your account. Here you can manage all of your personal information and orders.");
		  
//		  homepage.LoginToApplication("korla.ramesh@rediffmail.com","test123");	
//		  homepage.logoutApplication();
		 
//		 driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();
//		 driver.findElement(By.xpath(".//*[@id='email_create']")).sendKeys("ramesh.k@gmail.com");
//		 driver.findElement(By.xpath(".//*[@id='SubmitCreate']")).click();
//		 driver.findElement(By.xpath(".//*[@id='id_gender1']")).click();
//		 driver.findElement(By.xpath(".//*[@id='customer_firstname']")).sendKeys("ramesh");
//		 driver.findElement(By.xpath(".//*[@id='customer_lastname']")).sendKeys("korla");
//		 driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys("test123");
//		 Thread.sleep(4000);
//		// driver.findElement(By.cssSelector("option[value=\"20\"]")).click();
//       new Select(driver.findElement(By.id("days"))).selectByVisibleText("23");
//		 driver.findElement(By.cssSelector("option[value=\"23\"]")).click();
//		// new Select(driver.findElement(By.id("days"))).selectByVisibleText("regexp:23\\s+");
//		 
//		 driver.findElement(By.cssSelector("#months > option[value=\"9\"]")).click();
//		// new Select(driver.findElement(By.id("months"))).selectByVisibleText("regexp:September\\s");
//       new Select(driver.findElement(By.id("years"))).selectByVisibleText("1983");
//		 driver.findElement(By.cssSelector("option[value=\"1983\"]")).click();

//	   // new Select(driver.findElement(By.id("years"))).selectByVisibleText("regexp:1983\\s+");
//		
//		 
////		 Select days=new Select(driver.findElement(By.xpath(".//*[@id='days']")));
////		days.selectByValue("23");
//	//wait = new WebDriverWait(driver, 60);
////		 wait.until(ExpectedConditions.elementToBeClickable(By.id("days")));
////		 Select dropdown = new Select(driver.findElement(By.id("days"))); 
////		  dropdown.selectByIndex(23);
////		  
////		  wait.until(ExpectedConditions.elementToBeClickable(By.id("months")));
////		  Select dropdown1= new Select(driver.findElement(By.id("months"))); 
////			  dropdown1.selectByIndex(9);
////			  wait.until(ExpectedConditions.elementToBeClickable(By.id("years")));
////			  Select dropdown2= new Select(driver.findElement(By.id("years"))); 
////				  dropdown2.selectByValue("1983");
//		// new Select(driver.findElement(By.xpath(".//*[@id='months']"))).selectByValue("23");
////		 WebElement days = driver.findElement(By.xpath(".//*[@id='days']"));
////		 Select dropdown= new Select(days);
////		 dropdown.selectByValue("23");
////		 Thread.sleep(3000);
////		 new Select(driver.findElement(By.xpath(".//*[@id='months']"))).selectByValue("September");
////		 new Select(driver.findElement(By.xpath(".//*[@id='years']"))).selectByValue("1983");
////		WebElement months  = driver.findElement(By.xpath(".//*[@id='months']"));
////		Select mm=new Select(months);
////		mm.selectByValue("September");	
////		Thread.sleep(3000);
////		Select years  = new Select(driver.findElement(By.xpath(".//*[@id='years']")));
////		years.selectByValue("September");
////		 WebElement years = driver.findElement(By.xpath(".//*[@id='years']"));
////		 Select yy= new Select(years);   
////		yy.selectByValue("1983");
//		// Adding Address    selectByValue
//		 driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys("Ramesh"); 
//		 driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys("Korla"); 
//		 driver.findElement(By.xpath(".//*[@id='company']")).sendKeys("VMCLabs"); 
//		 driver.findElement(By.xpath(".//*[@id='address1']")).sendKeys("N Hamilton St, 100,"); 
//		 driver.findElement(By.xpath(".//*[@id='address2']")).sendKeys("Wisconsin"); 
//		 driver.findElement(By.xpath(".//*[@id='city']")).sendKeys("Madison");
//		 
////		 WebElement State = driver.findElement(By.xpath(".//*[@id='id_state']"));
////		 Select dropdown3= new Select(State);
////		 dropdown3.selectByValue("Indiana");
//		 +//		 new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Indiana");+//		 driver.findElement(By.cssSelector("#id_state > option[value=\"14\"]")).click();+//		 
//		 driver.findElement(By.xpath(".//*[@id='postcode']")).sendKeys("53703"); 
//		 
////		 WebElement country = driver.findElement(By.xpath(".//*[@id='id_country']"));
////		 Select cuntry= new Select(country);
////		 cuntry.selectByValue("United States");
//		 
//		 new Select(driver.findElement(By.id("id_country"))).selectByVisibleText("United States");
//		 driver.findElement(By.cssSelector("#id_country > option[value=\"21\"]")).click();
//		 
//		 driver.findElement(By.xpath(".//*[@id='phone_mobile']")).sendKeys("01541166650"); 
//		 driver.findElement(By.xpath(".//*[@id='alias']")).sendKeys("MyHomeAddress"); 
//		 
//		 driver.findElement(By.xpath(".//*[@id='submitAccount']")).click();
//		 // .//*[@id='email_create'] .//*[@id='months'], .//*[@id='address2'], .//*[@id='id_country'], .//*[@id='alias']
//	     Assert.assertEquals(driver.findElement(By.xpath(".//*[@id='center_column']/p")).getText(), "Welcome to your account. Here you can manage all of your personal information and orders.");
//	     System.out.println("Assert");
    }
    @AfterClass    
    public void endTest() throws InterruptedException 
    {
       Thread.sleep(5000);
       homepage.clickonlogout();
  	   driver.quit();
    }
}
 
