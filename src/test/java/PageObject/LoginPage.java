package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement username;
	
	public void setUserName(String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	public void setPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement clickLoginbtn;
	
	public void clickLoginButton()
	{
		clickLoginbtn.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement logout;
	
	public void clickLogoutBtn()
	{
		logout.click();
	}
	
	@FindBy(xpath="//td[normalize-space()='Manger Id : mngr524719']")
	WebElement haedline;
	
	public String getWelcomeMsg()
	{
		String welcome=haedline.getText();
		return welcome;
	}
}
