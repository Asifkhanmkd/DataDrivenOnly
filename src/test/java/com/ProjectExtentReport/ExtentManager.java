package com.ProjectExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	
	public static   ExtentReports getInstance(String fileName) {
		
		
		
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(fileName);
		
		
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Software Testing Board Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setReportName("Extent Report");
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Tester Name", "Muhammad Asif");
		extent.setSystemInfo("Build No", "Test.v.1.0");
		
		return extent;
		
		
	}

	
}

