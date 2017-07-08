package mainUtils;

import org.apache.log4j.Logger;

public class LoggerUtils 
{

	public Logger logger;
	
	public Logger getlog()
	{
		return logger = Logger.getLogger(this.getClass());
	}
	
	
	
}
