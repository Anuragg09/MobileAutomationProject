package android.MobileAutomationProject.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandExecution
{

	Process p;
	ProcessBuilder pb;
	
	
	public  String runcommnad(String command ) throws IOException
	{
			p = Runtime.getRuntime().exec(command);
			BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line= "";
			String allline = "";
			int i=1;
			while ((line = r.readLine())!=null) 
			{
				allline = allline+""+line+"\n";
				if (line.contains("Console LogLevel: Debug") && line.contains("Complete")) 
				{
					break;
				}
				i++;
			}
			
			return allline;
	}
	
	
}
