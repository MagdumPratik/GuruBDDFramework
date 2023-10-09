package StepDefination;

import org.openqa.selenium.WebDriver;

import com.github.javafaker.Faker;

import PageObject.AddNewAcount;
import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import Utilities.ReadProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

public class BaseClass {
	public static WebDriver driver;
	public static LoginPage lp;
	Logger logger;
	public static AddNewCustomer ac;
	public static AddNewAcount ad;
	public ReadProperty rp;
	
//	Generate Email id
	Faker faker=new Faker();
	public String setEmailByfaker()
	{
	String emailid=faker.internet().emailAddress();
	return emailid;
	}
	
	 public static String generateFileName(){
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	        LocalDateTime now = LocalDateTime.now();
	        String currentDirectory = System.getProperty("user.dir");
	        String filePath = currentDirectory + ".\\Screenshot\\";
	        String fileName = filePath + dtf.format(now) + ".png";
	        return fileName;
	    }
}
