package com.test.BaseProperties;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import com.test.ExcelReader.ExcelReader;
import com.test.customListener.Listener;


public class testBase {
	public static final Logger log = Logger.getLogger(testBase.class.getName());
    public static WebDriver driver;
     //  public InternetExplorerDriver  driver;
     String url ="http://automationpractice.com/index.php";
     // String browser = "firefox";
     String browser = "Chrome";
     //   String browser = "InternetExplorer";
     ExcelReader excel;
     Listener lis;
     
     public void init()
     {
    	selectBrowser(browser);
   // 	lis = new Listener(driver);
    	getUrl(url);
    	String log4jConfPath = "Log4j.properties";
    	PropertyConfigurator.configure(log4jConfPath);
     }
	 private void getUrl(String  url) 
	 {
		log.info("navigating to url:" + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	 }
	 private void selectBrowser(String browser) 
	 {
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			log.info("Creating Object of" + browser);
			driver = new FirefoxDriver();
		}
				//  System.setProperty("webdriver.ie.driver", "D://IEDriverServer.exe");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			log.info("Creating Object of" + browser);
			driver = new ChromeDriver();
		}
		
		if(browser.equalsIgnoreCase("InternetExplorer"))
		{
			System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			log.info("Creating Object of" + browser);
			driver = new InternetExplorerDriver();
		}
	 }
	public String[][] getData(String excelName, String sheetName)
	{ 
		// /uiAutoframework/src/main/java/com/test/Autoframework/uiAutoframework/data/TestData.xlsx
		String path = System.getProperty("user.dir")+ "/src/main/java/com/test/DataSource/"+ excelName;
		excel = new ExcelReader(path);
	    String[][] data = excel.getDataFromSheet(sheetName, excelName);
	    return data;
	}
	
    public void getScreenShot(String Name)
    {
    	Calendar calendar = Calendar.getInstance();
    	SimpleDateFormat formater  = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");
    	
    	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	try
    	{
    		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/com/test/screenshot/";
    	    File destFile = new File((String) reportDirectory + Name +" "+ formater.format(calendar.getTime())+ ".png");    	
            FileUtils.copyFile(scrFile, destFile);
            Reporter.log("<a herf='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' Width='100'/></a>");
        }        
     	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    }

}
