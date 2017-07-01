package android.MobileAutomationProject.basePackage;

import io.appium.java_client.AppiumDriver;

public class DriverManger 
{
	public static ThreadLocal<AppiumDriver> tl = new ThreadLocal<AppiumDriver>();
	public static AppiumDriver getAppiumDriver()
	{
		return tl.get();
	}	
}
