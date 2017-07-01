package android.MobileAutomationProject.basePackage;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import android.MobileAutomationProject.utils.TestResultUtils;

public class BaseTest 
{

	
	
	@BeforeMethod
	public void tearUp()
	{
		LaunchMobileApp launch = new LaunchMobileApp();
	}
	
	
	
	@AfterMethod
	public void tearnDown(ITestResult result)
	{
		
		TestResultUtils test = new TestResultUtils();
		test.getFailureStatus(result);
		MobilePage m = new MobilePage();
		m.closeApp();
	}
	
}
