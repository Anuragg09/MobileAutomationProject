package android.MobileAutomationProject.utils;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;


import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import mainUtils.LoggerUtils;

public class AppiumUtils extends JavaUtils {
	
	public ArrayList<String> devicelist = new ArrayList<String>();
	CommandExecution cmd = new CommandExecution();
	public Logger logger;
	public AppiumUtils()
	{
		logger = Logger.getLogger(this.getClass());
	}
	
	public void startAppiumServer() throws IOException, InterruptedException {
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();  
		DefaultExecutor executor = new DefaultExecutor(); 
		executor.execute(getcommandCapabilites(), resultHandler);
		Reporter.log("Startig the Appium Server", true);
		Thread.sleep(50000);
	}

	public ArrayList<String> getDeviceID() throws IOException
	{
	
		String device = cmd.runcommnad("adb devices");
		
		logger.info("Straertr");
	
		logger.info(device.toString());
		String lines[] = device.split("\n");
		if (lines.length<=0)
		{
			System.out.println("No Device Found");
		}
		else 
		{
		for (int i = 1; i <lines.length; i++) 
		{
			lines[i]= lines[i].replaceAll("\\s+", "");
			if (lines[i].contains("device"))
			{
				lines[i] = lines[i].replaceAll("device", "");
				String DeveID = lines[i];
				
				
				devicelist.add(DeveID);
				System.out.println(devicelist);
			}
		}	
		}
		System.out.println(device);
		return devicelist;
	}
	
	public CommandLine getcommandCapabilites()
	{
		CommandLine command = new CommandLine("cmd");
		command.addArgument(readProperty("DIRECTORY"));  
		command.addArgument(readProperty("NODEPATH"));  
		command.addArgument(readProperty("APPIUMPATH"));  
		command.addArgument(readProperty("APPIUMSERVERADDRESSTEXT"));  
		command.addArgument(readProperty("APPIUMSERVERADDRESS"));  
		command.addArgument(readProperty("APPIUMSERVERPORTTEXT"));  
		command.addArgument(readProperty("APPIUMSERVERPORTNUMBER"));  
		command.addArgument(readProperty("NORESET"));	
		return command;
	}
	public void generateLogsInConsole() {
		Reporter.log("Generating the logs in Console", true);
		AppiumServiceBuilder asb = new AppiumServiceBuilder();
		asb.withArgument(GeneralServerFlag.LOG_LEVEL, "Generate the Logs in Console");
	}

	public  void stopAppiumServer() throws IOException { 
		Reporter.log("Stoping the Appium Server", true);
		CommandLine command = new CommandLine("cmd");  
		command.addArgument("/c");  
		command.addArgument("taskKill");  
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();  
		DefaultExecutor executor = new DefaultExecutor();  
		executor.execute(command, resultHandler);  
	}

	/*public void startAppiumServer() throws IOException, InterruptedException {
		CommandLine command = new CommandLine("cmd");
		command.addArgument("/C");  
		command.addArgument("C:/Program^ Files^ (x86)/Appium/node.exe");  
		command.addArgument("C:/Program^ Files (x86)/Appium/node_modules/appium/bin/appium.js");  
		command.addArgument("--address");  
		command.addArgument("0.0.0.0");  
		command.addArgument("--port");  
		command.addArgument("4723");  
		command.addArgument("--no-reset");	    
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();  
		DefaultExecutor executor = new DefaultExecutor(); 
		executor.execute(command, resultHandler);
		Reporter.log("Startig the Appium Server", true);
		Thread.sleep(50000);
	}

	public void generateLogsInConsole() {
		Reporter.log("Generating the logs in Console", true);
		AppiumServiceBuilder asb = new AppiumServiceBuilder();
		asb.withArgument(GeneralServerFlag.LOG_LEVEL, "Generate the Logs in Console");
	}

	public  void stopAppiumServer() throws IOException { 
		Reporter.log("Stoping the Appium Server", true);
		CommandLine command = new CommandLine("cmd");  
		command.addArgument("/c");  
		command.addArgument("taskKill");  
		command.addArgument("/F");
		command.addArgument("/IM");
		command.addArgument("node.exe");
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();  
		DefaultExecutor executor = new DefaultExecutor();  
		executor.execute(command, resultHandler);  
	}*/
}
