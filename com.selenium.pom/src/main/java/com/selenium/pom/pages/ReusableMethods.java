package com.selenium.pom.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReusableMethods {

	 public static Properties myProperty;
     public static ExtentReports extent;
     // public static ExtentReports extent;

	public static Properties loadPropertyFile(File f) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			myProperty = new Properties();
			myProperty.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myProperty;

	}
    /*
     * Description: Method used to create log report 
     */
	
	public static ExtentReports createLogReport() {
		System.out.println("Hello");
     
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/LogReport/AutomationReport.html");
		
	    System.out.println("My location"+System.getProperty("user.dir"));
	    
		System.out.println("Hello again");
		System.out.println(System.getProperty("user.dir") + "/LogReport");
	    extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host Name", "MyLocal");
		extent.setSystemInfo("User Name", "Namrata");
		htmlreporter.config().setDocumentTitle("Extent Report");
		htmlreporter.config().setReportName("Functional Testing Report");
		return extent;
	}
	
	/*public static ExtentTest createLogReport(ExtentTest loggers) {
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(
				System.getProperty("user.dir")
						+ "/LogReport/AutomationReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host Name", "MyLocal");
		extent.setSystemInfo("User Name", "Namrata");
		htmlreporter.config().setDocumentTitle("Extent Report");
		htmlreporter.config().setDocumentTitle("Functional Testing Report");
		// ExtentTest loggers=extent.createTest(testcaseName);
		return loggers;
	}*/
}
