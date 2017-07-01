package android.MobileAutomationProject.utils;

import java.io.IOException;

import org.testng.ITestResult;

import android.MobileAutomationProject.basePackage.MobilePage;

public class TestResultUtils
{

	
	public void getFailureStatus(ITestResult result)
	{
		
		if (result.getStatus() == ITestResult.FAILURE) 
		{
			MobilePage m = new MobilePage();
			try {
				m.takeScreenshot(getClass().getName().toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			
		}
		else if (result.getStatus() == ITestResult.SKIP) 
		{
			
		}
	}
	
	
}
