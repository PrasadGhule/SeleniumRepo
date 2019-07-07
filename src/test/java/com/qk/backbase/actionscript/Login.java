package com.qk.backbase.actionscript;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	//public static WebDriver d;
	@FindBy(how=How.XPATH,using="//input[@id='userNameKeyboard']") WebElement unwe;
	@FindBy(how=How.XPATH,using="//input[@class='login-userName log-password-keyboard ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required']") WebElement pwdwe;
	@FindBy(how=How.XPATH,using="//button[@id='lgButtton']") WebElement submitwe;
		
	public void login() throws IOException, InterruptedException 
	{				
	    //Excel Handling
	    File f=new File("A:\\Selenium\\Workspace\\Backbase\\src\\test\\java\\com\\qk\\backbase\\data\\DataFile.xlsx");
	    FileInputStream fis=new FileInputStream(f);
	    XSSFWorkbook wb=new XSSFWorkbook(fis);
	    XSSFSheet sheet=wb.getSheet("Login");
	    
	    String un=sheet.getRow(1).getCell(0).getStringCellValue();
	    unwe.sendKeys(un);
	    String pwd=sheet.getRow(1).getCell(1).getStringCellValue();
	    pwdwe.sendKeys(pwd);
	    Thread.sleep(2000);
	    submitwe.click();
	    
	    Thread.sleep(5000);
	}

}
