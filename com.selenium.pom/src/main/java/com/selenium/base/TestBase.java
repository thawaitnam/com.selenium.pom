package com.selenium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.selenium.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties propertyFile;
	

	public TestBase()  {
		//File file = new File("./src/main/java"+"/com/selenium/config/MyProperty.properties");
			try {
				propertyFile = new Properties();
				FileInputStream file;
		     	file = new FileInputStream("C:\\Users\\Num\\git\\com.selenium.pom\\com.selenium.pom\\src\\main\\java\\com\\selenium\\config\\MyProperty.properties");
		
			System.out.println(file);
			propertyFile.load(file);
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	//	FileInputStream fis = null;
		
	}

	public static void launchBrowser() {

		String browserName = propertyFile.getProperty("BROWSER_NAME");

		if (browserName.equalsIgnoreCase("FIREFOX")) {	

			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Num\\Google Drive\\NAMWorld\\QATester\\NamWorkPlace\\com.selenium.pom\\src\\test\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			//driver.get(propertyFile.getProperty("URL"));
	}

		else if (browserName.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Num\\Google Drive\\NAMWorld\\QATester\\NamWorkPlace\\com.selenium.pom\\src\\test\\resources\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.implicitly_wait, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.page_load_timeout, TimeUnit.SECONDS);

		driver.get(propertyFile.getProperty("URL"));
		
	}

}
