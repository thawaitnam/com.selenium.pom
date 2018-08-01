package com.selenium.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selenium.base.TestBase;
public class LoginPage extends TestBase{

	@FindBy(how=How.XPATH,using=".//*[@id='username']")
	WebElement username;
	@FindBy(how=How.XPATH,using=".//*[@id='password']")
	WebElement password;
	@FindBy(how=How.XPATH,using=".//*[@id='Login']")
	WebElement login;
	
	/*
	 * Initialize Page Objects and variables
	 */
	public LoginPage()
	{
	
		PageFactory.initElements(driver, this); //initialize objects here automatically driver.findelement
	
	}
	
	public String verifyPageTitle()
	{
		return driver.getTitle();
		//Assert.assertEquals("hekki", actualtitle);
		
	}
	
	public HomePage loginP(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
	
	}


}
