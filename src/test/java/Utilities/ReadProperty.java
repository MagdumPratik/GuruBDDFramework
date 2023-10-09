package Utilities;
import java.io.*;
import java.util.Properties;

public class ReadProperty {
	Properties pro;
	String src="config.properties";
	public ReadProperty()
	{
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println("File not Found"+e.getMessage());
		}
	}
	public String getBrowser()
	{
		String browser=pro.getProperty("browser");
		return browser;
	}
	
	
}
