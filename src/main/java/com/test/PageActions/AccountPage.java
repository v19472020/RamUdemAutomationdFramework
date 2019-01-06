package com.test.PageActions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage 
{
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='main-navigation-links']/li[6]")
	WebElement Account;
	
	@FindBy(xpath=".//*[@id='login-form']/div/div[1]/div[2]/div/button")
	WebElement CreateAccount;
	
	@FindBy(xpath=".//*[@id='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath=".//*[@id='lastname']")
	WebElement LastName;
	
	@FindBy(xpath=".//*[@id='email_address']")
	WebElement emailAddress;
	
	@FindBy(xpath=".//*[@id='password']")
	WebElement Password;
	
	@FindBy(xpath=".//*[@id='confirmation']")
	WebElement ConfirmPassword;
	
	@FindBy(xpath=".//*[@id='form-validate']/div[3]/button")
	WebElement Submit;
	
	@FindBy(xpath=".//*[@id='search']")
	public
	WebElement Search;
	
	@FindBy(xpath=".//*[@id='search_mini_form']/div/button")
	public
	WebElement Searchbutton;
	
	@FindBy(xpath =".//*[@id='email']")
	WebElement email;
	
	@FindBy(xpath=".//*[@id='pass']")
	WebElement Pass;
	
	@FindBy(xpath=".//*[@id='send2']")
	WebElement Login;
	
	@FindBy(xpath=".//*[@id='feature-inner-34']/div")
	WebElement Productname;
	
	public AccountPage(WebDriver driver) 
	{ 		
	  PageFactory.initElements(driver, this);
	}
	
	public void LoginToApplication(String Email, String password) throws InterruptedException
	{
		Account.click();
		Thread.sleep(2000);
		email.sendKeys(Email);
		Thread.sleep(2000);
		Pass.sendKeys(password);
		Thread.sleep(2000);
		Login.click();
	}
	
	public void CreateAccount()
	{
		Account.click();
		CreateAccount.click();
		FirstName.sendKeys("KRamesh");
		LastName.sendKeys("Naidu");
		emailAddress.sendKeys("ramesh.naidu1@hotmail.com");
		
		Password.sendKeys("ramesh123");
		ConfirmPassword.sendKeys("");
        Submit.click();
		
	}
	public void CreateAccountValidate(String Firstname, String Lastname, String Email, String password, String confirmpassword)
	{
		Account.click();
		CreateAccount.click();
		FirstName.sendKeys(Firstname);
		LastName.sendKeys(Lastname);
		emailAddress.sendKeys(Email);
		
		Password.sendKeys(password);
		ConfirmPassword.sendKeys(confirmpassword);
        Submit.click();	
	}
	

	public void Products() throws InterruptedException 
	{
		
		Actions ac= new Actions(driver);
	//	driver.findElement(By.xpath("//div[@class='feature-product']/ul/li[3]/div/div/div/h2/a[contains(text(),'Water-to-Go 75cl Filter Twin Pack')]")).click();
		driver.get("https://www.watertogo.eu/water-to-go-water-bottle-in-black-with-black-sleeve.html");
		 
	//	 Productname.click();
	     ac.doubleClick(driver.findElement(By.xpath(".//*[@id='product-textual']/div[2]/div[1]"))).build().perform();
	     ac.keyDown(Keys.SHIFT).sendKeys(Keys.UP).sendKeys(Keys.UP).sendKeys(Keys.HOME).perform();   
	     ac.keyUp(Keys.SHIFT).sendKeys(Keys.CONTROL+"c").perform(); 
	     Thread.sleep(2000);
         ac.click(driver.findElement(By.xpath(".//*[@id='search']"))).perform();
	      try 
	      {
			Robot rb=new Robot();
			rb.keyPress(KeyEvent.VK_CONTROL);
			//Thread.sleep(2000);	
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			
		  } catch (AWTException e) {
			e.printStackTrace();
		  }
	      ac.sendKeys(Keys.BACK_SPACE).perform();
	      Thread.sleep(6000);
	      driver.findElement(By.xpath(".//*[@id='search_mini_form']/div/button")).click();
	      Thread.sleep(8000);

//		//Paste into Search field  driver.findElement(By.id("search"))
		WebElement element = Search;
	//	element.sendKeys("50cl Pink GO! Water Bottle");
	    element.sendKeys(Keys.CONTROL+"v");
		Searchbutton.click();
		
	}

}
