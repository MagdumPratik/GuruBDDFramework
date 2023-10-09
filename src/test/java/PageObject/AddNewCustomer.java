package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
	
	WebDriver ldriver;
	
	public AddNewCustomer(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Customer']")
	WebElement newCustomer;
	
	public void clickAddNewCustomer()
	{
		newCustomer.click();
	}
	
	@FindBy(xpath="//input[@name='name']")
	WebElement firstName;
	
	public void AddFirstName(String fm)
	{
		firstName.sendKeys(fm);
	}
	
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement DOB;
	
	public void setDate(String date)
	{
		DOB.sendKeys(date);
	}
	
	@FindBy(xpath="//input[@value='m']")
	WebElement Gender;
	
	public void selectGender()
	{
		Gender.click();
		
	}
	
	@FindBy(xpath="//textarea[@name='addr']")
	WebElement adress;
	
	public void setAddress(String add)
	{
		adress.sendKeys(add);
	}
	
	@FindBy(xpath="//input[@name='city']")
	WebElement city;
	
	public void setCity(String ct)
	{
		city.sendKeys(ct);
	}
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state;
	
	public void setState(String st)
	{
		state.sendKeys(st);
	}
	
	@FindBy(xpath="//input[@name='pinno']")
	WebElement pin;
	
	public void setPincode(String st)
	{
		pin.sendKeys(st);
	}
	
	@FindBy(xpath="//input[@name='telephoneno']")
	WebElement mobileNumber;
	
	public void setMobileNumber(String st)
	{
		mobileNumber.sendKeys(st);
	}

	@FindBy(xpath="//input[@name='emailid']")
	WebElement Email;
	
	public void setEmailAddress(String st)
	{
		Email.sendKeys(st);
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	public void setPassword(String st)
	{
		Password.sendKeys(st);
	}
	
	@FindBy(xpath="//input[@name='sub']")
	WebElement clickSubmitBtn;
	
	public void submitBtn()
	{
		clickSubmitBtn.click();
	}
	
	@FindBy(xpath="//p[@class='heading3']")
	WebElement headline;
	
	public String getHeadline()
	{
	String head=headline.getText();
	return head;
	}
}
