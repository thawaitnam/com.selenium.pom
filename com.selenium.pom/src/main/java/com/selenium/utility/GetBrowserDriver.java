package com.selenium.utility;
import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.pom.pages.ReusableMethods;

public class GetBrowserDriver extends ReusableMethods {

	public static WebDriver driver;

	public static WebDriver launchBrowser(String browserName) {
		
		File file=new File("./src/test/MyProperty.properties");
		Properties propertyFile=ReusableMethods.loadPropertyFile(file);
	
		if (browserName.equalsIgnoreCase(propertyFile.getProperty("BROWSER_NAME"))) {
			
			//if(browserName=="FIREFOX"){
			System.out.println(browserName);

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Num\\Google Drive\\NAMWorld\\QATester\\NamWorkPlace\\com.selenium.pom\\src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(propertyFile.getProperty("URL"));
	
			//driver.get("https://login.salesforce.com");

		}

		else if (browserName.equalsIgnoreCase(propertyFile.getProperty(browserName))) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Num\\Google Drive\\NAMWorld\\QATester\\NamWorkPlace\\com.selenium.pom\\src\\test\\resources\\chromedriver.exe");
		
			driver = new ChromeDriver();
		}

		else if (browserName.equals(propertyFile.getProperty(browserName))) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

}
