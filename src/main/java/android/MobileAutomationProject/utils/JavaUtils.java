package android.MobileAutomationProject.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

import junit.framework.Assert;

public class JavaUtils
{
	public String currentDate()
	{
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd_HHMMss");
		String da = sd.format(date);
		System.out.println(da);
		return da;
	}

	public int  convert_Strinto_Int(String s)
	{
		return Integer.parseInt(s);
	}

	public void readExcel()
	{
		File file = new File(readProperty("ExcelFile"));
	}


	public String  readProperty(String key)
	{
		String value= null;
		try 
		{
			FileInputStream file = new FileInputStream("./config.properties");
			Properties prop = new Properties();
			prop.load(file);
			value = prop.getProperty(key);
		}catch (Exception e) {}
		return value;
	}

	public long getSystemTime()
	{
		long time = System.currentTimeMillis();
		return time;
	}

	public void assertStingValue(String actual,String expected)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log("Actual:: "+actual+"Expected:: "+expected,true);
	}

	public void assertbooleanValue(boolean val,boolean b)
	{
		Assert.assertEquals(val, b);
		Reporter.log("Actual:: "+val+"Expected:: "+b,true);
	}

	public void sleppfor(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String ExcelLibrary() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		String value ="";
		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Data");
		int rowcount = sheet.getLastRowNum();
		int columncount = sheet.getRow(0).getLastCellNum();
		for(int i = 0;i<rowcount;i++)
		{
		Cell rowvalue = sheet.getRow(i).getCell(0);
		if(rowvalue.equals("TC3"))
		{
			for(int j=0;j<columncount;j++)
			{
				Cell columnvalue = sheet.getRow(0).getCell(i);
				if(columnvalue.equals("Name"))
				{
				 value = sheet.getRow(i).getCell(j).toString();
				}
			}
		}
		}
		return value;
	}
	
	/*public void ExcelLibrary() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{

		FileInputStream fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Data");
		Iterator<Row> it = sheet.rowIterator();
		Header header = it.next();
		while(it.hasNext())
		{
			Row row = it.next();
			Cell cell = row.getCell(0);
			if(cell.equals("TC"))
			{
				for(int i= 0;i<column;i++)
				{
					String key = header.getCell(i).tiString();
					String value = rowvalue.getCell(i).toString();
					HashMap<String, String> hm = new HashMap<String, String>()
							hm.put(key, value);
				}
			}
		}
	}*/
}
