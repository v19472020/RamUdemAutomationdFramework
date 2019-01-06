package com.test.PageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage 
{
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	//@FindBy(xpath =".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signIn;

	@FindBy(xpath ="//*[@id='email']")
	//@FindBy(id ="email")
	WebElement loginEmailAddress;
	
	@FindBy(xpath ="//*[@id='passwd']")
	WebElement loginpassword;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitButton;
	
	@FindBy(xpath = ".//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailed;
	
	@FindBy(xpath =".//*[@id='email_create']")
	WebElement email_create;
	
	@FindBy(xpath =".//*[@id='SubmitCreate']")
	WebElement CreateAccountbutton;
	
	@FindBy(xpath =".//*[@id='id_gender1']")
	WebElement Gender;
	
	@FindBy(xpath =".//*[@id='customer_firstname']")
	WebElement firstname;
	
	@FindBy(xpath =".//*[@id='customer_lastname']")
	WebElement lastname;
	
	@FindBy(xpath =".//*[@id='passwd']")
	WebElement password;
	
	//@FindBy(css="option[value=\"23\"]")
	@FindBy(xpath=".//*[@id='days']")
	WebElement days;
	
	//@FindBy(css="#months > option[value=\"9\"]")
	@FindBy(xpath=".//*[@id='months']")
	WebElement months;
	
	//@FindBy(css="option[value=\"1983\"]")
	@FindBy(xpath=".//*[@id='years']")
	WebElement years;
	
	@FindBy(xpath =".//*[@id='firstname']")
	WebElement first_name;
	
	@FindBy(xpath =".//*[@id='lastname']")
	WebElement last_name;
	
	@FindBy(xpath =".//*[@id='company']")
	WebElement Companyname;
	
	@FindBy(xpath = ".//*[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath = ".//*[@id='address2']")
	WebElement address2;
	
	@FindBy(xpath = ".//*[@id='city']")
	WebElement city;
	
	//@FindBy(css ="#id_state > option[value=\"14\"]")
	@FindBy(xpath=".//*[@id='id_state']")
	WebElement State;
	
	@FindBy(xpath = ".//*[@id='postcode']")
	WebElement postcode;
	
	@FindBy(css ="#id_country > option[value=\"21\"]")
	WebElement Country;
	
	@FindBy(xpath =".//*[@id='phone_mobile']")
	WebElement Mobileno;
	
	@FindBy(xpath = ".//*[@id='alias']")
	WebElement alias;
	
	@FindBy(id = "submitAccount")
	WebElement submitAccount;
	
	@FindBy(xpath =".//*[@id='center_column']/p")
	WebElement MyAccount;
	
	@FindBy(xpath = ".//*[@id='header']/div[2]/div/div/nav/div[2]/a")
	WebElement logout;
	
	@FindBy(xpath=".//*[@id='center_column']/div/div[1]/ul/li[3]/a/span")
	WebElement MyAddresses;
	
	@FindBy(xpath=".//*[@id='center_column']/div[2]/a/span")
	WebElement AddNewAddress;
	
	@FindBy(xpath=".//*[@id='firstname']")
	WebElement Addrs_firstname;
	
	@FindBy(xpath=".//*[@id='lastname']")
	WebElement Addrs_lastname;
	
	@FindBy(xpath=".//*[@id='company']")
	WebElement company;
	
	@FindBy(xpath=".//*[@id='address1']")
	WebElement Address1;
	
	@FindBy(xpath=".//*[@id='address2']")
	WebElement Address2;
	
	
	@FindBy(xpath=".//*[@id='city']")
	WebElement Addrs_city;

    @FindBy(css="#id_state > option[value=\"14\"]")
    WebElement Address_state;
    
    
    
    @FindBy(xpath=".//*[@id='postcode']")
    WebElement Addrs_Postcode;

	@FindBy(xpath=".//*[@id='id_country']")
	WebElement Addrs_Country;
	
	@FindBy(xpath=".//*[@id='phone']")
	WebElement Addrs_Homephone;
	
	@FindBy(xpath=".//*[@id='phone_mobile']")
	WebElement mobilephone;
	
	@FindBy(xpath=".//*[@id='other']")
	WebElement AdditionalInfo;
	
	@FindBy(xpath=".//*[@id='alias']")
	WebElement Alias;
	
	@FindBy(xpath=".//*[@id='submitAddress']")
	WebElement SubmitAddress;
	
	@FindBy(xpath=".//*[@id='center_column']/ul/li/a/span")
	public
	WebElement BacktoAddress;
	
	@FindBy(xpath="//*[@class='account']")
	WebElement account;
	
	@FindBy(xpath="//*[@class='page-heading']")
	WebElement NewAddressMessage;
	
	//@FindBy(xpath=".//*[@id='add_address']/p[1]")
	@FindBy(xpath=".//*[@id='center_column']")
	WebElement Alert;
	
	@FindBy(xpath="//a[@class='logout']")
	WebElement SignOut;
	
	public HomePage(WebDriver driver) 
	{ 		
	   PageFactory.initElements(driver, this);
	}
	public void LoginToApplication(String emailAddress, String password)
	{
		signIn.click();
		log.info("Click the SignIn" + signIn.toString());
		loginEmailAddress.sendKeys(emailAddress);
		log.info("enter the emailaddress:" +emailAddress +"Object of EmailAddress" +loginEmailAddress.toString());
		loginpassword.sendKeys(password);
		log.info("enter the password:" +password +"Object of EmailAddress" +loginpassword.toString());
		submitButton.click();
		log.info("Click to Submit button and Obejct is:" +submitButton.toString());
		//logout.click();
	}
	public boolean verifyLogoutDisplay()
	{
		try{
			logout.isDisplayed();
			log.info("logout button is displayed and object is:-" +logout.toString());
			return true;
			
		}catch(Exception e){
			return false;
		}				
	}
	public void clickonlogout()
	{
		logout.click();
		log.info("Clicked on logout button and object is:-" +logout.toString());
	}
	public String getInvalidLoginText()
	{
		log.info("Error Message is:" +authenticationFailed.toString());
		return authenticationFailed.getText();
		
	}  //.//*[@id='center_column']/div/div/ol/li
	public String getAlertText()
	{
		log.info("Alerrt Message is:" +Alert.toString());
		return Alert.getText();
	}
//	public String getAlertMessageText()
//	{
//		log.info("Alerrt Message is:" +Alert.toString());
//		return Alert.getText();
//	}
	public  void days() 
	{
	    By days =  By.cssSelector("option[value=\"23\"]");
	    driver.findElement(days).click();      
	}	
	public  void months() 
	{
	    By months =  By.cssSelector("#months > option[value=\"9\"]");
	    driver.findElement(months).click();      
	}	
	public  void years() 
	{
	    By years =  By.cssSelector("option[value=\"1983\"]");
	    driver.findElement(years).click();      
	}	
	public  void Address_state() 
	{
	    By State =  By.cssSelector("#id_state > option[value=\"14\"]");
	  //  By State = By.cssSelector("select[id='id_state']");
	    driver.findElement(State).click();      
	}	
	public  void country() 
	{
	    By country =  By.cssSelector("#id_country > option[value=\"21\"]");
	    driver.findElement(country).click();      
	}	
	public String getAccountCreateMessage()
	{
		log.info("Error Message is:" +authenticationFailed.toString());
		return MyAccount.getText();		
	}
	public void CreateAccount() throws InterruptedException
	{
		signIn.click();
		log.info("Sign In button Clicking");
		email_create.sendKeys("kramesh2@rediffmail.com");
		log.info("Enter the email address");
		CreateAccountbutton.click();
		log.info("Create Account button Clicking");
		Gender.click();	
		log.info("Select the Gender radio button");
		firstname.sendKeys("Korla");
		log.info("Enter the First Name");
		lastname.sendKeys("Ramesh");
		log.info("Enter the Last Name");
		password.sendKeys("test123");
		log.info("Enter the Password ");
//		days.click();
//		months.click();
//		years.click();
		Select date = new Select(days);
		date.selectByValue("25");
		log.info("Select the Date from days dropdown");
		Thread.sleep(2000);
		Select month = new Select(months);
		month.selectByValue("9");
		log.info("Select the month from Months dropdown");
		Thread.sleep(2000);
		Select year = new Select(years);
		year.selectByValue("1983");
		log.info("Select the year from Years dropdown");
		Thread.sleep(2000);
		first_name.sendKeys("Ramesh");
		last_name.sendKeys("Naidu");
		Companyname.sendKeys("Vectramind");
		address1.sendKeys("N Hamilton St, 101");
		address2.sendKeys("Wisconsin");
		city.sendKeys("Madison");
		State.click();
		postcode.sendKeys("53703");
		Country.click();
		Mobileno.sendKeys("9948116666");
		alias.clear();
		alias.sendKeys("Home Address");
		submitAccount.click();	
	}
	public void AccountCreation(String email, String FirstName, String LastName, String pswd, String Date, String Month, String Year,
			String FirstName1, String LastName1, String Company, String Address1, String Address2, String City, String States, String PostCode,
			String Mobile_No, String Alias) throws InterruptedException
	{
		signIn.click();
		log.info("Sign In button Clicking");
		email_create.sendKeys(email);
		log.info("Enter the email address");
		CreateAccountbutton.click();
		log.info("Create Account button Clicking");
		Gender.click();
		log.info("Select the Gender radio button");
		firstname.sendKeys(FirstName);
		log.info("Enter the First Name");
		lastname.sendKeys(LastName);
		log.info("Enter the Last Name");
		password.sendKeys(pswd);
		log.info("Enter the Password ");
		Select date = new Select(days);
		date.selectByValue(Date);
		log.info("Select the Date from days dropdown");
		Thread.sleep(2000);
		Select month = new Select(months);
		month.selectByValue(Month);
		log.info("Select the month from Months dropdown");
		Thread.sleep(2000);
		Select year = new Select(years);
		year.selectByValue(Year);
		log.info("Select the year from Years dropdown");
		Thread.sleep(2000);
		first_name.sendKeys(FirstName1);
		log.info("Enter the First_Name1 ");
		last_name.sendKeys(LastName1);
		log.info("Enter the Last_Name1 ");
		Companyname.sendKeys(Company);
		log.info("Enter the Company name ");
		address1.sendKeys(Address1);
		log.info("Enter the Address1");
		address2.sendKeys(Address2);
		log.info("Enter the Address2");
		city.sendKeys(City);
		log.info("Enter the City Name");
		Select state = new Select(State);
		state.selectByVisibleText(States);
		log.info("Select the State from the Statedropdown");
//		State.click();
		postcode.sendKeys(PostCode);
		log.info("Enter the Postcode of area");
		Country.click();
		Mobileno.sendKeys(Mobile_No);
		log.info("Enter the Mobile number ");
		alias.clear();
		alias.sendKeys(Alias);
		log.info("Enter the Alias Address ");
		submitAccount.click();	
		SignOut.click();
		log.info("Sign out the Accounts");
	}
	public  void Adrs_state() 
	{
//		By Adrs_state =  By.cssSelector("#uniform-id_state > option[value=\"14\"]");
//	    driver.findElement(Adrs_state).click();  
//      By state =  By.id("id_state");
//	    driver.findElement(By.cssSelector("input[name='id_state']")).sendKeys("Indiana");
//	    WebElement element = driver.findElement(By.cssSelector("selector[id='uniform-id_state']"));
//	    element.sendKeys("Indiana");
		new Select(driver.findElement(By.id("id_state"))).selectByVisibleText("Indiana");
//		driver.findElement(state).selectByVisibleText("Indiana");
	}
//      uniform-id_country
	
	public  void Addrs_Country() 
	{
	   // By state =  By.id("id_state");
	    WebElement element = driver.findElement(By.cssSelector("select[id='uniform-id_country']"));
	    WebElement option = element.findElement(By.cssSelector("United States"));
	    option.click();     
	}	
	public String getNewAddressMessage()
	{
		//log.info("Error Message is:" +authenticationFailed.toString());
		return NewAddressMessage.getText();		
	}
	public void AddNewAddress() throws InterruptedException
	{   		
		log.info("Click the account" + account.toString());
		account.click();
	    Thread.sleep(4000);
	    log.info("Click to the MyAddress Tab" + MyAddresses.toString());
	    MyAddresses.click();
	    log.info("Click To the AddNewAddress Tab" + AddNewAddress.toString());
	    AddNewAddress.click();
	    Thread.sleep(4000);
	    log.info("Enter the Firstname" + Addrs_firstname.toString());
	    Addrs_firstname.clear();
		Addrs_firstname.sendKeys("MunithaRamesh");
		log.info("Enter the lastname" + Addrs_lastname.toString());
		Addrs_lastname.clear();
		Addrs_lastname.sendKeys("Korla");
		log.info("Enter the company name" + company.toString());
		company.clear();
		company.sendKeys("RameshComputers");
		log.info("Enter the Address1" + Address1.toString());
		Address1.sendKeys("N Hamilton St, 103");
		log.info("Enter the Address2" + Address2.toString());
		Address2.sendKeys("Wisconsin");
		log.info("Enter the city name" + Addrs_city.toString());
		Addrs_city.sendKeys("Madison");
		log.info("Select the State" + Address_state.toString());
		Address_state.click();
		log.info("Enter the PostCode" + Addrs_Postcode.toString());
		Addrs_Postcode.sendKeys("53704");
		log.info("Enter the Addrs_Country" + Addrs_Country.toString());
		Addrs_Country.click();
		log.info("Enter the Homephone" + Addrs_Homephone.toString());
		Addrs_Homephone.sendKeys("0113453443");
		log.info("Enter the mobilephone" + mobilephone.toString());
		mobilephone.sendKeys("01553456667");
		log.info("Enter the AdditionalInfo" + AdditionalInfo.toString());
		AdditionalInfo.sendKeys("Madison Address");
		log.info("Enter the Alias" + Alias.toString());
		Alias.clear();
		Alias.sendKeys("HomeAddress");
		log.info("Enter the SubmitAddress" + SubmitAddress.toString());
		SubmitAddress.click();
	}
	public void AddNewAddress1() throws InterruptedException
	{   		
		log.info("Click the account" + account.toString());
		account.click();
	    Thread.sleep(4000);
	    log.info("Click to the MyAddress Tab" + MyAddresses.toString());
	    MyAddresses.click();
	    log.info("Click To the AddNewAddress Tab" + AddNewAddress.toString());
	    AddNewAddress.click();
	    Thread.sleep(4000);
	    log.info("Enter the Firstname" + Addrs_firstname.toString());
	    Addrs_firstname.clear();
		Addrs_firstname.sendKeys("MunithaRamesh");
		log.info("Enter the lastname" + Addrs_lastname.toString());
		Addrs_lastname.clear();
		Addrs_lastname.sendKeys("Korla");
		log.info("Enter the company name" + company.toString());
		company.clear();
		company.sendKeys("RameshComputers");
		log.info("Enter the Address1" + Address1.toString());
		Address1.sendKeys("N Hamilton St, 103");
		log.info("Enter the Address2" + Address2.toString());
		Address2.sendKeys("Wisconsin");
		log.info("Enter the city name" + Addrs_city.toString());
		Addrs_city.sendKeys("Madison");
		log.info("Select the State" + Address_state.toString());
		Address_state.click();
		log.info("Enter the PostCode" + Addrs_Postcode.toString());
		Addrs_Postcode.sendKeys("53704");
		log.info("Enter the Addrs_Country" + Addrs_Country.toString());
		Addrs_Country.click();
		log.info("Enter the Homephone" + Addrs_Homephone.toString());
		Addrs_Homephone.sendKeys("0113453443");
		log.info("Enter the mobilephone" + mobilephone.toString());
		mobilephone.sendKeys("01553456667");
		log.info("Enter the AdditionalInfo" + AdditionalInfo.toString());
		AdditionalInfo.sendKeys("Madison Address");
		log.info("Enter the Alias" + Alias.toString());
		Alias.clear();
		Alias.sendKeys("HomeAddress");
		log.info("Enter the SubmitAddress" + SubmitAddress.toString());
		SubmitAddress.click();
	}
}
 
