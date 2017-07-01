package android.MobileAutomationProject.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.Reporter;

import junit.framework.Assert;

public class JavaUtils
{

	public String currentDate()
	{
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd_HHMMss");
		String da = sd.format(date);
		System.out.println(da);
		return da;
	}
	
	public int  convert_Strinto_Int(String s)
	{
		return Integer.parseInt(s);
	}
	
	public void readExcel()
	{
		File file = new File(readProperty("ExcelFile"));
	}
	
	
	public String  readProperty(String key)
	{
		String value= null;
		try 
		{
			FileInputStream file = new FileInputStream("./config.properties");
			Properties prop = new Properties();
			prop.load(file);
			 value = prop.getProperty(key);
		}catch (Exception e) {}
		return value;
	}
	
	public long getSystemTime()
	{
		 long time = System.currentTimeMillis();
		 return time;
	}
	
	public void assertStingValue(String actual,String expected)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log("Actual:: "+actual+"Expected:: "+expected,true);
	}
	
	public void assertbooleanValue(boolean val,boolean b)
	{
		Assert.assertEquals(val, b);
		Reporter.log("Actual:: "+val+"Expected:: "+b,true);
	}
	
	public void sleppfor(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
