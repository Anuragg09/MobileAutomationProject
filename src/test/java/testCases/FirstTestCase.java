package testCases;

import org.testng.annotations.Test;

import android.MobileAutomationProject.basePackage.BaseTest;
import mobileScreens.HomeScreen;

public class FirstTestCase extends BaseTest
{

	@Test
	public void tes()
	{
		HomeScreen home = new HomeScreen();
		home.enterEmail();
	}
	
	
}
