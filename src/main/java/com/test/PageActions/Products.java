package com.test.PageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='sf-with-ul']")
	WebElement Dresses;
	
	//Casual Dresses
	@FindBy(xpath="//a[contains(text(),'Casual Dresses')]")
	WebElement CasualDresses;
	
	public Products(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void MenuHover() throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		act.moveToElement(Dresses).build().perform();
		Thread.sleep(3000);
		act.moveToElement(CasualDresses).click().perform();
	}

}
