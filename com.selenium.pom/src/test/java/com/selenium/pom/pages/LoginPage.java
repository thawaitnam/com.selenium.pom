package com.selenium.pom.pages;
import java.io.File;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {
	
   //@FindBy(id="user_login") WebElement username;
	
	public static WebDriver driver;
	public static Properties propertyFile;
	public static File file;
	
	@FindBy(how=How.XPATH,using=".//*[@id='username']")
	WebElement username;
	@FindBy(how=How.XPATH,using=".//*[@id='password']")
	WebElement password;
	@FindBy(how=How.XPATH,using=".//*[@id='Login']")
	WebElement login;
	
	public WebDriver login_home(WebDriver driver)
	{
		//file=new File("./src/test/MyProperty.properties");
		file=new File("./src/test/resources/MyProperty.properties");
		//C:\Users\Num\Google Drive\NAMWorld\QATester\NamWorkPlace\com.selenium.pom\src\test\resources
		propertyFile=ReusableMethods.loadPropertyFile(file);
		System.out.println("KKKKKK"+propertyFile.getProperty("USER_NAME"));
		username.sendKeys(propertyFile.getProperty("USER_NAME"));
		//username.sendKeys("hjhjjh");
		password.sendKeys(propertyFile.getProperty("PASSWORD"));
		login.submit();
		return driver;
	}

}
