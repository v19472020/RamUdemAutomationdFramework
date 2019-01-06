package com.test.customListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.BaseProperties.testBase;

public class Listener extends testBase implements ITestListener
{
  //  WebDriver driver;
       
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}
	public void onTestSuccess(ITestResult arg0) 
	{
		 Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");	   
		 String methodName = arg0.getName();
		 if(arg0.isSuccess())
		 {
		       File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			   try
			   {
			        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/com/test/ScreenshotSucess/";
			        File destFile = new File((String) reportDirectory + "" + methodName + "_" + formater.format(calendar.getTime())+".png");				
					FileUtils.copyFile(scrFile, destFile);
					Reporter.log("<a herf='" +destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath()+"' height='100' width='100'/> </a>");
				}
				catch(IOException e)
				{
				     e.printStackTrace();
				}
		  }
		
	}
	public void onTestFailure(ITestResult result) 
	{
		  Calendar calendar = Calendar.getInstance();
		  SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyy_hh_mm_ss");		   
		  String methodName = result.getName();
		  if(!result.isSuccess())
		  {
		       File scrFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			   try{
			        String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+ "/src/main/java/com/test/ScreenshotFailure/";
			        File destFile = new File((String) reportDirectory + "" + methodName + "_" + formater.format(calendar.getTime())+".png");				
					FileUtils.copyFile(scrFile, destFile);
					Reporter.log("<a herf='" +destFile.getAbsolutePath()+"'> <img src ='" + destFile.getAbsolutePath()+"' height='100' width='100'/> </a>");
				}
				catch(IOException e)
				{
				     e.printStackTrace();
				}
		   }
		
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
