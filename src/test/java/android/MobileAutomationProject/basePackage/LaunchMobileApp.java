package android.MobileAutomationProject.basePackage;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchMobileApp extends BasePage
{
	
	public LaunchMobileApp()
	{
		super();
		try {
			super.LaunchApp();
		} catch (Exception e) {
	
		}
	
		DriverManger.tl.set(super.driver);
		PageFactory.initElements(driver, this);	
	}

}
