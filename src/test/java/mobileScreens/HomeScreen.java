package mobileScreens;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import android.MobileAutomationProject.basePackage.MobilePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends MobilePage
{
	
	public HomeScreen()
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@FindBy(id = "logo")
	private MobileElement logoImg;
	
	
	@FindBy(name = "Email")
	private MobileElement emailTB;
	
	public void clickonLogo()
	{
		clickEle(logoImg);
	}
	
	public void enterEmail()
	{
		typeText(emailTB, "Harirkishna");
	}
}
