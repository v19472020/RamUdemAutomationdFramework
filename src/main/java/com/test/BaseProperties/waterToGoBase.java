package com.test.BaseProperties;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import com.test.ExcelReader.ExcelReader;

public class waterToGoBase 
{
	public WebDriver driver;
    //  public InternetExplorerDriver  driver;
    String url =" https://www.watertogo.eu";
   /// String browser = "firefox";
    String browser = "Chrome";
    //   String browser = "InternetExplorer";
    ExcelReader excel;
    
    public void init()
    {
   	selectBrowser(browser);
   	getUrl(url);
  
    }
	 private void getUrl(String  url) 
	 {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	 }
	 private void selectBrowser(String browser) 
	 {
//				if(browser.equalsIgnoreCase("firefox"))
//				{
//					System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.19.0-win64\\geckodriver.exe");
//					driver = new FirefoxDriver();
//				}
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
				if(browser.equalsIgnoreCase("InternetExplorer"))
				{
					System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
				//	log.info("Creating Object of" + browser);
					driver = new InternetExplorerDriver();
				}
	 }
	public String[][] getData(String excelName, String sheetName)
	{ 
		// /uiAutoframework/src/main/java/com/test/Autoframework/uiAutoframework/data/TestData.xlsx
		String path = System.getProperty("user.dir")+ "/src/main/java/com/test/Autoframework/uiAutoframework/data/"+ excelName;
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
   		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/com/test/Autoframework/uiAutoframework/screenshot/";
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
