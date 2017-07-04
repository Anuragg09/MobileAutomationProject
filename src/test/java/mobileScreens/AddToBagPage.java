package mobileScreens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import android.MobileAutomationProject.basePackage.BasePage;
import android.MobileAutomationProject.utils.JavaUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddToBagPage extends BasePage{

	JavaUtils ju = new JavaUtils();
	public AddToBagPage()
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="btn_skip")
	private MobileElement skipBTN;
	
	@AndroidFindBy(id="btn_mlogin")
	private MobileElement loginBTN;
	
	@AndroidFindBy(name="Find all?departments here")
	private MobileElement findSkip;
	
	@AndroidFindBy(name="email id / mobile number")
	private MobileElement emailTB;
	
	@AndroidFindBy(xpath="//android.widget.ImageView/../android.widget.EditText[1]")
	private MobileElement mobTB;
	
	@AndroidFindBy(id="etPass")
	private MobileElement pwdTB;
	
	@AndroidFindBy(id="btn_mlogin")
	private MobileElement loginButton;
	
	@AndroidFindBy(id="btn_msignup")
	private MobileElement signupButton;
	
	@AndroidFindBy(id="com.flipkart.android:id/mainMenu")
	private MobileElement mainMenuButton;
	
	@AndroidFindBy(id="com.flipkart.android:id/title")
	private MobileElement myAccountButton;
	
	@AndroidFindBy(id="expandable_cat_cell")
	private MobileElement laptopOption;
	
	@AndroidFindBy(id="android.view.View")
	private MobileElement logoutButton;
	
	@AndroidFindBy(className="android.widget.ImageButton")
	private MobileElement imageButton;
	
	@AndroidFindBy(id = "search_widget_textbox")
	private MobileElement searchBox;
	
	/*@AndroidFindBy(id = "search_widget_textbox")
	public MobileElement searchTextbox;*/
	
	@AndroidFindBy(id = "auto_suggest_list_view")
	private MobileElement searchListView;
	
	@AndroidFindBy(id = "incorrect_login_text")
	private MobileElement listFirstText;
	
	@AndroidFindBy(id = "//android.view.View[@index='2']/android.widget.TextView[@text='Filter' and @index='1']")
	private MobileElement filterButton;
	
	@AndroidFindBy(id = "//android.widget.TextView[@text='APPLY' and @index='0']")
	private MobileElement applyButton;
	
	@AndroidFindBy(id = "")
	private MobileElement clickProduct;
	
	public void findSkipMethod()
	{
		waitUntilElementVisible(findSkip);
		findSkip.click();
	}
	
	public void skipWelcom_Page()
	{
		waitUntilElementVisible(skipBTN);
		clickOnElement(skipBTN);
		Reporter.log("Clicking on Skip Button",true);
	}
	
	public void clickonLogin()
	{
		waitUntilElementVisible(loginBTN);
		loginBTN.click();
		Reporter.log("Clickong On Logon Button",true);
	}
	
	public void logintoApp()
	{
		waitUntilElementVisible(loginButton);
		try {
			emailTB.clear();
			emailTB.sendKeys("8985319232");
		} catch (Exception e) {
			mobTB.clear();
			mobTB.sendKeys("8985319232");
		}
		pwdTB.click();
		pwdTB.sendKeys("gsreddy539");
		loginButton.click();
	}
	public void signupMethod()
	{
		waitUntilElementVisible(signupButton);
		signupButton.click();
	}
	public void myAccountMethod() throws InterruptedException
	{
		waitUntilElementVisible(mainMenuButton);
		mainMenuButton.click();
		myAccountButton.click();
		Thread.sleep(8000);
		driver.tap(1, 1000, 1920, 3000);
		loginButton.click();
		Thread.sleep(3000);
	}
	
	public void clickImageMethod()
	{
		imageButton.click();
	}
	public void clickListFirstElement() 
	{
	//Click on Search Button
	clickOnElement(searchBox);
	//Click first item from List
	WebElement element = driver.findElement(By.id("auto_suggest_list_view"));
	element.findElement(By.id("incorrect_login_text")).click();
	waitUntilElementVisible(filterButton);
	//Click on Filter Button
	clickOnElement(filterButton);
	//Set the Price
	WebElement slider=driver.findElement(By.xpath("//android.widget.TextView[@text='Min']/../android.view.View[@index=4]/android.view.View"));
	int xAxisStartPoint = slider.getLocation().getX();
	System.out.println(xAxisStartPoint);
	int xAxisEndPoint = xAxisStartPoint + slider.getSize().getWidth();
	int yAxis = slider.getLocation().getY();
	System.out.println(yAxis);
	driver.swipe(110, yAxis, 400, yAxis, 100);
	clickOnElement(applyButton);
	WebElement recyclerView = driver.findElement(By.className("android.support.v7.widget.RecyclerView"));
	recyclerView.findElement(By.xpath("//android.view.View[@index='0']")).click();
	
	}
}
