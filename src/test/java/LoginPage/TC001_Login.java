package LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.PageActions.AccountPage;
import com.test.BaseProperties.waterToGoBase;

public class TC001_Login extends waterToGoBase
{

    AccountPage account;
	
	@BeforeTest
	public void setup()
	{
		init();
	}
	@Test
	public void verifylogin() throws InterruptedException
	{
		account = new AccountPage(driver);
		Thread.sleep(2000);
		account.LoginToApplication("ramesh.korla@hotmail.com", "ramesh123");
		Actions dragger = new Actions(driver);     // .//*[@id='feature-inner-37']/div; .//*[@id='feature-inner-37']/div/h2/a
		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath(".//*[@id='feature-inner-37']/div"));
		// drag downwards
		int numberOfPixelsToDragTheScrollbarDown = 15;
		for (int i=10;i<150;i=i+numberOfPixelsToDragTheScrollbarDown){
			// this causes a gradual drag of the scroll bar, 10 units at a time
		  dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
		}
	    account.Products();
//		Actions dragger = new Actions(driver);     // .//*[@id='feature-inner-37']/div; .//*[@id='feature-inner-37']/div/h2/a
//		WebElement draggablePartOfScrollbar = driver.findElement(By.xpath(".//*[@calss='product-name']"));
//		// drag downwards
//		int numberOfPixelsToDragTheScrollbarDown = 15;
//		for (int i=10;i<150;i=i+numberOfPixelsToDragTheScrollbarDown){
//			// this causes a gradual drag of the scroll bar, 10 units at a time
//		  dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
//		}

	}
	
	@AfterTest
	public void endTest()
	{
		driver.quit();
	}

}
