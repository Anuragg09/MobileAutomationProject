package testCases;

import org.testng.annotations.Test;

import android.MobileAutomationProject.basePackage.BaseTest;
import mobileScreens.AddToBagPage;

public class AddToBagTest extends BaseTest 
{
	@Test(groups = "Smoke")
	public void addToBagMethod() throws InterruptedException
	{
		AddToBagPage atb = new AddToBagPage();
		atb.skipWelcom_Page();
		atb.clickListFirstElement();
	}
}
