package com.testProject.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ProjectExtentReport.ExtentListener;
import com.aventstack.extentreports.Status;
import com.testProject.base.Testbase;
import com.testProject.utilities.TestUtil;

public class UserSignInTest extends Testbase {

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void userSignInTest(String userName, String password) {

		driver.findElement(By.cssSelector(or.getProperty("signIn-link"))).click();
		log.info("Clicked on Login Title link");
		Reporter.log("Clicked on Login Title link<br>");
		ExtentListener.test.log(Status.INFO, "Clicked on Login Title link");
		
		driver.findElement(By.cssSelector(or.getProperty("userEmail"))).sendKeys(userName);
		log.info("Typed in the Username");
		Reporter.log("Typed in the Username<br>");
		ExtentListener.test.log(Status.INFO, "Typed in the Username");
		
		driver.findElement(By.cssSelector(or.getProperty("userPassword"))).sendKeys(password);
		log.info("Typed in the Password");
		Reporter.log("Typed in the Password<br>");
		ExtentListener.test.log(Status.INFO, "Typed in the Password");
		
		driver.findElement(By.xpath(or.getProperty("signIn-btn"))).click();
		log.info("Clicked on Sign in button");
		Reporter.log("Clicked on Sign in button<br>");
		ExtentListener.test.log(Status.INFO, "Clicked on Sign in button");
		
		boolean isTrue = IsElementPresent(By.xpath(or.getProperty("welcome")));

		if (isTrue) {
			log.info("Yes, Welcome Title is visible");
			log.info("Sign in Successful");
			Reporter.log("Yes, Welcome Title is visible<br>");
			Reporter.log("Sign in Successful<br>");
			ExtentListener.test.log(Status.INFO, "Yes, Welcome Title is visible");
			ExtentListener.test.log(Status.INFO, "Sign in Successful");
			

		} else {

			log.info("Welcome Title is not visible");
			log.info("Sign in not Successful, Please check username or Password");
			Reporter.log("Welcome Title is not visible");
			Reporter.log("Sign in not Successful, Please check username or Password<br>");
			ExtentListener.test.log(Status.INFO, "Welcome Title is not visible");
			ExtentListener.test.log(Status.INFO, "Sign in not Successful, Please check username or Password");
			
			
			Assert.fail("Seems like the Username or password is wrong");
		}
		
		driver.findElement(By.xpath(or.getProperty("dropDown-btn"))).click();
		driver.findElement(By.xpath(or.getProperty("signOut-btn"))).click();

	}

	/*
	 * @DataProvider public Object[][] getData() { String sheetname = "Sheet1";
	 * 
	 * int rowCount = excel.getRowCount(sheetname); int colCount =
	 * excel.getColumnCount(sheetname);
	 * 
	 * Object[][] data= new Object[rowCount-1][colCount];
	 * 
	 * for(int row=2;row <=rowCount;row++) { for(int col=0;col<colCount;col++) {
	 * 
	 * data[row-2][col] =excel.getCellData(sheetname, col, row);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return data; }
	 */

}
