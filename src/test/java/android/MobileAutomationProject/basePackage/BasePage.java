package android.MobileAutomationProject.basePackage;

import java.awt.List;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import android.MobileAutomationProject.utils.AppiumCapabilites;
import android.MobileAutomationProject.utils.JavaUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class BasePage
{

	public AppiumDriver driver;
	AppiumCapabilites app = new AppiumCapabilites();
	JavaUtils ja = new JavaUtils();


	public BasePage()
	{
		driver = DriverManger.getAppiumDriver();
	}

	public AppiumDriver<MobileElement> LaunchApp()
	{
		try {
			driver = new AndroidDriver<MobileElement>(new URL(ja.readProperty("AndroidURL")), app.desiredcapforPhoneCall());
			implicitWait();
			System.out.println("Launching Mobile Android APP");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;	
	}

	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void waitUntilElementClickable(MobileElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementVisible(MobileElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickOnElement(MobileElement element) {
		waitUntilElementVisible(element);
		element.click();
	}

	public void clickOnElementUsingIndex(List elements, int index) {

	}

	/*public void clickOnElement(List<MobileElement> elements)
		   {
	   clickOnElement(elements.get(0));
   }*/

	public void closeApp()
	{
		driver.closeApp();
		Reporter.log("Closing App", true);
	}


	public void resetAPP()
	{
		driver.resetApp();
		Reporter.log("Reseting Mobile APP", true);
	}

	public void installAPP(String appPath)
	{
		driver.installApp(ja.readProperty("Path"));
	}

	public void deviceDimension() 
	{
		Dimension dimensions = driver.manage().window().getSize();
		int screenWidth = dimensions.getWidth();
		System.out.println("Device Width::" +screenWidth);
		int screenHeight = dimensions.getHeight();
		System.out.println("Device Height::" +screenHeight);
	}
}