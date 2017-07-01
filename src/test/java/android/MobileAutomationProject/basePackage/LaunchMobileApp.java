package android.MobileAutomationProject.basePackage;

import org.openqa.selenium.support.PageFactory;

public class LaunchMobileApp extends BasePage
{
	
	public LaunchMobileApp()
	{
		super();
		super.LaunchApp();
		DriverManger.tl.set(driver);
		PageFactory.initElements(driver, this);	
	}

}
