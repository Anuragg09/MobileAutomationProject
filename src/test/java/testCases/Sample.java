package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import android.MobileAutomationProject.basePackage.LaunchMobileApp;
import android.MobileAutomationProject.utils.AppiumCapabilites;
import android.MobileAutomationProject.utils.AppiumUtils;

public class Sample 
{

	
	public static void main(String[] args) throws IOException {
		
		AppiumUtils a = new AppiumUtils();
		a.getDeviceID();
		
	}
	
}
