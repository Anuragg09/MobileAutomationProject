package android.MobileAutomationProject.basePackage;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import android.MobileAutomationProject.utils.AppiumCapabilites;
import android.MobileAutomationProject.utils.TestResultUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTest 
{

	
	@BeforeMethod(alwaysRun=true)
	public void tearUp()
	{
		LaunchMobileApp launch = new LaunchMobileApp();
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearnDown(ITestResult result)
	{
		TestResultUtils test = new TestResultUtils();
		test.getFailureStatus(result);
		MobilePage m = new MobilePage();
		m.closeApp();
	}
	
}
