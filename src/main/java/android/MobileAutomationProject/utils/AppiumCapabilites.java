package android.MobileAutomationProject.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumCapabilites extends JavaUtils
{

	public final String DEVICENAME = "deviceName";
	public final String PLATFANAME  = "platformName";
	
	public DesiredCapabilities desiredcapforPhoneCall()
	{
		DesiredCapabilities capabilites = new DesiredCapabilities();
		capabilites.setCapability(DEVICENAME, readProperty("DEVICENAME"));
		capabilites.setCapability(PLATFANAME, readProperty("PLATFARM"));
		capabilites.setCapability("platformVersion",readProperty("PLATFARMVERSION"));
		capabilites.setCapability("appPackage", readProperty("APPPACKAGE"));
		capabilites.setCapability("appActivity", readProperty("APPACTIVITY"));
		return capabilites;
	}
	
	
	
	
}
