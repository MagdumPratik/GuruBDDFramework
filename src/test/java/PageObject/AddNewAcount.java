package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewAcount {
	
	WebDriver ldriver;
	public AddNewAcount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Account']")
	WebElement newAccountBtn;
	
	public void clickNewAccountBtn()
	{
		newAccountBtn.click();
	}
	
	@FindBy(xpath="//p[@class='heading3']")
	WebElement accountGeneratedmsg;
	
	public String generatedMsg()
	{
		String msg=accountGeneratedmsg.getText();
		return msg;
	}
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement customerid;
	
	public void setCustomerid(String id)
	{
		customerid.sendKeys(id);
	}
	
	@FindBy(xpath="//select[@name='selaccount']")
	WebElement accountType;
	
	public void selectAccountType(int ac)
	{
		Select sc=new Select(accountType);
		sc.selectByIndex(ac);
	}
	
	@FindBy(xpath="//input[@name='inideposit']")
	WebElement initaialDeposit;
	
	public void setInitialDeposit(String dp)
	{
		initaialDeposit.sendKeys(dp);
	}
	
	@FindBy(xpath="//input[@name='button2']")
	WebElement submitBtn;
	
	public void submitButton()
	{
		submitBtn.click();
	}
	
	
}
