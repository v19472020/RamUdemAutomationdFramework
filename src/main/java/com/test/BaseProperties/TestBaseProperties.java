package com.test.BaseProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBaseProperties {
	
	public WebDriver driver = null;
	public Properties prop = new Properties();
	//@Parameters( {"browser"}) 
	public void Login() throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\workspace\\AutoframeworkUI\\src\\main\\java\\com\\test\\config\\DataProperties.properties");
		prop.load(fis); 	    
		//System.out.println(prop.getProperty("username"));
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); 
		    System.out.println("Chrome"); 
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.16.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Firefox");
		}
		else{
			System.setProperty("webdriver.ie.driver","E:\\SeleniumWebDrivers\\IEDriverServer_x64_3.13.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

}
