package com.testProject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.testProject.utilities.ExcelReader;

public class Testbase {

	public static WebDriver driver;
	public static Properties or;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(Testbase.class.getName());
	public static WebDriverWait wait;
	public static ExcelReader excel=new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");	

	@BeforeSuite
	public void setUp() {
		
		PropertyConfigurator
				.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

		config = new Properties();
		or = new Properties();

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("config file loaded to read the Configuration values");

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			or.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Object Repository file loaded to read the object locators values");

		if (config.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (config.getProperty("browser").equals("firefox")) {

			driver = new FirefoxDriver();
		}

		driver.get(config.getProperty("url"));
		log.info("Navigated to url " + config.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Windows miximized");
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		wait=new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(config.getProperty("explicit.wait"))));
	}

	public boolean IsElementPresent(By by) {

		try {

			WebElement ele=driver.findElement(by);
			wait.until(ExpectedConditions.visibilityOf(ele));
			log.info("Is the Welcome Title visible?");
			
			return true;

		} catch (NoSuchElementException e) {
         
			return false;

		}

	}
	
	

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.close();
		}
	}

}
