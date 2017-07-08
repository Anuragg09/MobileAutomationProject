package android.MobileAutomationProject.utils;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumCapabilites extends JavaUtils
{
	AppiumUtils ap = new AppiumUtils();

	public final String DEVICENAME = "deviceName";
	public final String PLATFORMNAME  = "platformName";
	public final String PLATFORMVERSION  = "platformVersion";
	public final String APPPACKAGE  = "appPackage";
	public final String APPACTIVITY  = "appActivity";
	
	public DesiredCapabilities desiredcapforPhoneCall() throws IOException
	{
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setCapability(DEVICENAME,ap.getDeviceID().toString());
		capabilites.setCapability(PLATFORMNAME, readProperty("PLATFARM"));
		capabilites.setCapability(PLATFORMVERSION, readProperty("PLATFARMVERSION"));
		capabilites.setCapability(APPPACKAGE, readProperty("APPPACKAGE"));
		capabilites.setCapability(APPACTIVITY, readProperty("APPACTIVITY"));
		return capabilites;
	}
	
	
	
	
}
