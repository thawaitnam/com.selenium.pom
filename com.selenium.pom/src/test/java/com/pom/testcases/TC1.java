package com.pom.testcases;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.pom.pages.LoginPage;
import com.selenium.pom.pages.ReusableMethods;
import com.selenium.utility.GetBrowserDriver;
public class TC1 extends GetBrowserDriver{
	  public static WebDriver driver;
	  public static ExtentReports extent;
	  public static ExtentTest loggers;
	  //LoginPage loginObj=new LoginPage();
	
	@Test
	public void LoginSalesForce() throws InterruptedException
	{
		driver=launchBrowser("FIREFOX");
		extent =ReusableMethods.createLogReport();
		extent.createTest("LoginSalesForce").log(Status.INFO, "Browser Launched");
		loggers=extent.createTest("LoginSalesForce");
		loggers.log(Status.INFO, "Firefox browser is launched..");
		LoginPage login_page =PageFactory.initElements(driver, LoginPage.class);
		login_page.login_home(driver);
		extent.flush();
		driver.quit();
	}

}
	