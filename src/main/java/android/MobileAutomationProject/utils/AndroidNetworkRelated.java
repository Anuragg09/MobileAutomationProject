package android.MobileAutomationProject.utils;

import java.io.IOException;

import org.testng.Reporter;

public class AndroidNetworkRelated extends JavaUtils {
	
	public void enableWifi() throws IOException, InterruptedException {
		Reporter.log("Enable WIFI Connection");
		//To Wifi OFF
		/*String commadToRun = "\\Users\\sande_000\\AppData\\Local\\Android\\sdk\\platform-tools\\adb shell settings put global airplane_mode_on 0";
		Process process1 = Runtime.getRuntime().exec(commadToRun);*/
		Process process = Runtime.getRuntime().exec(readProperty("DISABLEWIFI"));
		process.waitFor();
		//By Using Activity 
		/*String commadToRun1 = "\\Users\\sande_000\\AppData\\Local\\Android\\sdk\\platform-tools\\adb shell am broadcast -a android.intent.action.AIRPLANE_MODE";
		Process process1 = Runtime.getRuntime().exec(commadToRun1);*/
		Process process1 = Runtime.getRuntime().exec(readProperty("AIRPLANEMODE"));
		process1.waitFor();
	}
	
	public void disableWifi() throws IOException, InterruptedException {
		Reporter.log("Disable WIFI Connection");
		/*String commadToRun = "\\Users\\sande_000\\AppData\\Local\\Android\\sdk\\platform-tools\\adb shell settings put global airplane_mode_on 1";
		Process process = Runtime.getRuntime().exec(commadToRun);*/
		Process process = Runtime.getRuntime().exec(readProperty("ENABLEWIFI"));
		process.waitFor();
		//By Using Activity
		/*String commadToRun1 = "\\Users\\sande_000\\AppData\\Local\\Android\\sdk\\platform-tools\\adb shell am broadcast -a android.intent.action.AIRPLANE_MODE";
		Process process1 = Runtime.getRuntime().exec(commadToRun1);*/
		Process process1 = Runtime.getRuntime().exec(readProperty("AIRPLANEMODE"));
		process1.waitFor();
	}
}
