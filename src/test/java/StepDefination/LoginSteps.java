package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import com.github.javafaker.Name;

import PageObject.AddNewAcount;
import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import Utilities.ReadProperty;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps extends BaseClass{
	
	@Before
	public void setUp()
	{
		rp=new ReadProperty();
		logger=logger.getLogger("LoginSteps");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("SetUp method executed...........");
		
		String browser=rp.getBrowser();
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			 driver.manage().window().maximize();
			 break;
			 
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			
		default :
			driver=null;
			break;
		}
				
		
	}

	@Given("user launch browser")
	public void user_launch_browser() throws InterruptedException {
	   lp=new LoginPage(driver);
	   Thread.sleep(2000);
	   logger.info("****************Chrome Browser successFully Strated !!*************");
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) throws InterruptedException {
	  driver.get(url);
	  Thread.sleep(3000);
	  logger.info("****************URL successFully Strated !!*************");
	}

	@When("user pass Email as {string} and Password as {string}")
	public void user_pass_Email_as_and_Password_as(String us, String ps) throws InterruptedException {
		Thread.sleep(2000);
	    lp.setUserName(us);
	    Thread.sleep(2000);
	    lp.setPassword(ps);
	    Thread.sleep(2000);
	    logger.info("****************Email And Password Successfullu Added !!*************");
	}

	@When("click on login button")
	public void click_on_login_button() throws InterruptedException {
	   lp.clickLoginButton();
	   try {
		   Alert alert=driver.switchTo().alert();
		   alert.accept();
	   }
	   catch(NoAlertPresentException e)
	   {
		   System.out.println("Alert Not Displayed!!");
	   }
	   Thread.sleep(4000);
	   logger.info("****************Clicked Login Buttton !!*************");
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String expected) {
	   String title=driver.getTitle();
	   if(title.equals(expected))
	   {
		   Assert.assertTrue(true);
	   }
	   else
	   {
		   Assert.assertTrue(false);
		   
	   }
	   logger.info("****************Verifying page title !!*************");
	}

	@When("click on logout button")
	public void click_on_logout_button() throws InterruptedException {
	   lp.clickLogoutBtn();Thread.sleep(2000);
	   try {
		   Alert alert=driver.switchTo().alert();
		   alert.accept();
	   }
	   catch(NoAlertPresentException e)
	   {
		   System.out.println("Alert Not Displayed!!");
	   }
	   Thread.sleep(2000);
	   logger.info("****************Successfully Log out !!*************");
	}

//	@Then("close Browser")
//	public void close_Browser() {
//	   driver.close();
//	   logger.info("****************Browser Closed !!*************");
//	}
	

//************Add Customer detais**********************************
	@When("click on add new Customer")
	public void click_on_add_new_Customer() throws InterruptedException {
		ac=new AddNewCustomer(driver);
		ac.clickAddNewCustomer();
		Thread.sleep(2000);
	}

	@When("user enters customer info")
	public void user_enters_customer_info() throws InterruptedException {
	   ac.AddFirstName("PratikRaja");
	   ac.selectGender();
	   ac.setDate("12-12-1998");
	   ac.setAddress("Waghave");
	   ac.setCity("Nanded");
	   ac.setState("Maharashtra");
	   ac.setPincode("416230");
	   ac.setMobileNumber("4578457896");
	   ac.setEmailAddress(setEmailByfaker());
	   ac.setPassword("123456789");
	   ac.submitBtn();
	   Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expected) {
		String actual=ac.getHeadline();
		if(expected.equals(actual))
		{
			Assert.assertTrue(true);
			logger.info("Customer Added Successfully!!");
		}
		else
		{
			driver.switchTo().alert().accept();
			Assert.assertTrue(false);
			logger.info("Customer Not Added!!");
		}
	}

//	@Then("close browser")
//	public void close_browser() {
//	    driver.quit();
//	}

//**********************Add New Account**************************
	@When("click on add new Account")
	public void click_on_add_new_Account() throws InterruptedException {
	    ad=new AddNewAcount(driver);
	    ad.clickNewAccountBtn();
	    Thread.sleep(5000);
	    try
	    {
	    	Alert alert=driver.switchTo().alert();
	    	alert.accept();
	    }
	    catch(NoAlertPresentException e)
	    {
	    	logger.info("Alert not dislplayed");
	    }
	}

	@When("user enters customer account info")
	public void user_enters_customer_account_info() throws InterruptedException {
	   ad.setCustomerid("8127");
	   ad.selectAccountType(0);
	   ad.setInitialDeposit("555555");
	   Thread.sleep(2000);
	   ad.submitButton();
	   Thread.sleep(2000);
	}

	@Then("User can view acccount generated massage {string}")
	public void user_can_view_acccount_generated_massage(String expected) {
	    
		String actualMsg=ad.generatedMsg();
		if(expected.equals(actualMsg))
		{
			Assert.assertTrue(true);
			logger.info("Acount generated Successfully!!");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Account not generated!!!");
			}
	}

	@After
public void tearDown(Scenario sc) throws IOException
{
	
	logger.info("Tear Down method executed...........");
	if(sc.isFailed()==true)
	{ 

		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(generateFileName()));
	}
	else
	{
		logger.info("Test PAssed!!!!!!!!");
	}
	driver.quit();
}
}
