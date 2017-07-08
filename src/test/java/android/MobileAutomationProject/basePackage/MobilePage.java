package android.MobileAutomationProject.basePackage;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


import android.MobileAutomationProject.utils.JavaUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MobilePage extends BasePage
{
	JavaUtils ja = new JavaUtils();
	
	public MobilePage()
	{
		super();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	TouchAction touch = new TouchAction(driver);
	
	public void navigateTo_ACtivity()
	{
		((StartsActivity) driver).startActivity(ja.readProperty("APPPACKAGE"), ja.readProperty("APPACTIVITY"));
	}
	
	public void naviagteBack()
	{
		driver.navigate().back();
	}
	
	public int getHegit()
	{
		int height = driver.manage().window().getSize().getHeight();
		Reporter.log("Height of Device:: "+height, true);
		return height;
	}
	
	public int getWiedth()
	{
		int width = driver.manage().window().getSize().getWidth();
		Reporter.log("width of Device:: "+width, true);
		return width;
	}
	public Point getPosition(MobileElement ele)
	{
		Point position = ele.getLocation();
		return position;
	}
	
	
	public int getXaxis(MobileElement ele)
	{
		int xaxis = getPosition(ele).getX();
		return xaxis;
	}
	
	public int getYaxis(MobileElement ele)
	{
		int yaxis = getPosition(ele).getY();
		return yaxis;
	}
	
	public void scrollUP()
	{
		//From Bottom to Top
		
		driver.swipe(getWiedth()-500,200, getWiedth()-500, getHegit()-300, 1000);
	}
	
	public void scrollDown()
	{
		//From Top to Bottom
		//driver.swipe(startx, starty, endx, endy, duration);
	}
	
	public void clickEle(MobileElement ele)
	{
		waitUntilElementClickable(ele);
		ele.click();
		Reporter.log("Clicking on Element", true);
	}
	
	public void typeText(MobileElement ele,String text)
	{
		waitUntilElementClickable(ele);
		ele.click();
		ele.clear();
		ele.sendKeys(text);
		Reporter.log("Sending Text of:: "+text, true);
	}
	
	public String getTextElement(MobileElement ele)
	{
		waitUntilElementClickable(ele);
		String text = ele.getText().toString();
		Reporter.log("Getting text From Element:: "+text, true);
		return text;
	}
	
	public String getAttributeValue(MobileElement ele)
	{
		waitUntilElementClickable(ele);
		String value = ele.getAttribute("value");
		Reporter.log("Getting Attribute of:: "+value, true);
		return value;
	}
	
	public Boolean elementDisplayed(MobileElement ele)
	{
		boolean val = ele.isDisplayed();
		ja.assertbooleanValue(val, true);
		return val;
	}
	
	public void elementEnabled()
	{
		
	}
	public void elmentVisible()
	{
		
	}
	
	public void takeScreenshot(String c) throws IOException
	{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,new File("./ScreenShotsFailures/"+c+"_"+ja.currentDate()+".png"));
	}
	
	public void tapElement(MobileElement ele)
	{
		waitUntilElementVisible(ele);
		driver.tap(1, ele, 1000);
	}
	
	public void tapUsingAxis(MobileElement ele)
	{
		driver.tap(1, getXaxis(ele), getYaxis(ele), 1000);
	}
	
	public void movetoElement(MobileElement ele)
	{
		touch.moveTo(getXaxis(ele), getYaxis(ele));	
	}
	
	
	public void scrolltoText(String text)
	{
		driver.scrollTo(text);
		Reporter.log("Scrolling to Text Using ::"+text, true);
	}
	
	public void ScrolltoExcat(String text)
	{
		 driver.scrollToExact(text);
		 Reporter.log("Scrolling to Text Using ::"+text, true);
	}
	
	
	
}
