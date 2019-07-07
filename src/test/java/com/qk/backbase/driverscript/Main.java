package com.qk.backbase.driverscript;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qk.backbase.actionscript.Login;

public class Main
{
	public static WebDriverWait myWaitVar;
	public static WebDriver d;
	public static void main(String[] args) throws InterruptedException, IOException
	{
		//Chromedriver path setup
		System.setProperty("webdriver.chrome.driver","A:\\Selenium\\Workspace\\Backbase\\src\\test\\resources\\chromedriver.exe");
		//Launching chrome browser
		d=new ChromeDriver();
		
		//Open url
		d.navigate().to("https://ecomuat.idfcbank.com/start");
		d.manage().window().maximize();	//maximize window
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       //Excel Handling
       File f=new File("A:\\Selenium\\Workspace\\Backbase\\src\\test\\java\\com\\qk\\backbase\\data\\DataFile.xlsx");
       FileInputStream fis=new FileInputStream(f);
       XSSFWorkbook wb=new XSSFWorkbook(fis);
       XSSFSheet sheet=wb.getSheet("Master");
               
       int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
       int a=0,b=1,c=2;
       for (int i = 1; i < rowCount+1; i++) 
       {
    	   String module=sheet.getRow(i).getCell(a).getStringCellValue();
    	   String submodule=sheet.getRow(i).getCell(b).getStringCellValue();
    	   String exestatus=sheet.getRow(i).getCell(c).getStringCellValue();
    	   
    	   if((module.equals("Login")) && (submodule.equals("Login")) && (exestatus.equals("Execute")))
    	   {
    		   d.navigate().to("https://ecomuat.idfcbank.com/start");
    		   Login l=PageFactory.initElements(d, Login.class);
    		   l.login();
    	   }

    	   
       }
       fis.close();
       //s.close();
       d.close();


}
}