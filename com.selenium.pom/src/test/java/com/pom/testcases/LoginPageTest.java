package com.pom.testcases;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.base.TestBase;
import com.selenium.pages.HomePage;
import com.selenium.pages.LoginPage;
import com.selenium.util.ReusableMethods;
import com.selenium.util.TestUtil;
public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	 
	public LoginPageTest() 
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException
	{
	   launchBrowser();
	   Thread.sleep(5000);
	   loginpage=new LoginPage();
	}
	
	@DataProvider
	public Object[][] readData() throws IOException
	{
		Object data[][]=TestUtil.readDataFromXl(propertyFile.getProperty("TESTDATA_SHEETNAME"));
		return data;
	}
	
    @Test(priority=1)
	public void LoginPageTitleTest()
	{
		String actualtitle=loginpage.verifyPageTitle();
	
		System.out.println("Not Matched");
		//Assert.assertEquals("hekki", actualtitle);
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homepage =loginpage.loginP(propertyFile.getProperty("USERNAME"), propertyFile.getProperty("PASSWORD"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
	