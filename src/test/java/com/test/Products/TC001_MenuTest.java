package com.test.Products;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.BaseProperties.testBase;
import com.test.PageActions.Products;

public class TC001_MenuTest extends testBase{
	
	Products pds;
	@BeforeTest
	public void BrowserSetup()
	{
		init();
	}
	
	@Test
	public void MenuTest() throws InterruptedException
	{
		pds = new Products(driver);
		pds.MenuHover();
	}

}
