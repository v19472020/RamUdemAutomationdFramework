package LoginPage;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.BaseProperties.TestBaseProperties;

public class TC002_Login extends TestBaseProperties {
	
	@BeforeTest
	public void browserSetup() throws IOException{
		Login();			
	}
	@Test
	public void LoginTest()
	{
		driver.get(prop.getProperty("url"));	
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(prop.getProperty("username"));
		System.out.println("Username:"+ driver.getTitle());
	//	driver.findElement(By.xpath(".//*[@id='login1']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath(".//*[@id='passwd']")).sendKeys(prop.getProperty("password"));
		System.out.println("Password:"+ driver.getTitle());
		driver.findElement(By.xpath(".//*[@id='SubmitLogin']")).click();
	}

}
