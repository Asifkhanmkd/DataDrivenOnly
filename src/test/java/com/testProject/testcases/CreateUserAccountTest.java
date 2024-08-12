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

public class CreateUserAccountTest extends Testbase {
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void createUserAccountTest(String firstName, String secondName,String email, String password, String confirmPassword) {

		// System.setProperty("org.uncommons.reportng.escape-output","false");

		driver.findElement(By.cssSelector(or.getProperty("createAccount.link"))).click();
		log.info("Clicked on Creat Account Button");
		Reporter.log("Clicked on Creat Account Button<br>");
		ExtentListener.test.log(Status.INFO, "Clicked on Creat Account Button");

		driver.findElement(By.cssSelector(or.getProperty("firstName"))).sendKeys(firstName);
		log.info("Typed the first Name");
		ExtentListener.test.log(Status.INFO, "Typed the first Name");
		Reporter.log("Typed the first Name<br>");

		driver.findElement(By.cssSelector(or.getProperty("lastname"))).sendKeys(secondName);
		log.info("Typed the Last Name");
		Reporter.log("Typed the Last Name<br>");
		ExtentListener.test.log(Status.INFO, "Typed the Last Name");

		driver.findElement(By.cssSelector(or.getProperty("email"))).sendKeys(email);
		log.info("Typed the email");
		Reporter.log("Typed the email<br>");
		ExtentListener.test.log(Status.INFO, "Typed the email");

		driver.findElement(By.cssSelector(or.getProperty("password"))).sendKeys(password);
		log.info("Typed the Password");
		Reporter.log("Typed the Password<br>");
		ExtentListener.test.log(Status.INFO, "Typed the Password");

		driver.findElement(By.cssSelector(or.getProperty("confirmPassword"))).sendKeys(confirmPassword);
		log.info("Confirm password by retyping");
		Reporter.log("Confirm password by retyping<br>");
		ExtentListener.test.log(Status.INFO, "Confirm password by retyping");

		driver.findElement(By.cssSelector(or.getProperty("createAccount.btn"))).click();

		boolean found = IsElementPresent(By.cssSelector(or.getProperty("MyAccount-Text")));
		log.info("Is the Element there? " + found);
		Reporter.log("Is the Welcome Element there? " + found);
		ExtentListener.test.log(Status.INFO, "Is the Welcome Element there? " + found);

		try {
			String myAccountText = driver.findElement(By.cssSelector(or.getProperty("MyAccount-Text"))).getText();
			Assert.assertEquals("My Account", myAccountText);
			log.info("Account Created successfully");

		} catch (Throwable t) {
			log.info("Account Already Exists,try another email");
			Reporter.log("Account Already Exists,try another email<br>");
			ExtentListener.test.log(Status.INFO, "Account Already Exists,try another email");

			Assert.fail("User with the email already registered");
		}

	}

/*
 * @DataProvider public Object[][] getData() { String sheetName = "Sheet2"; int
 * rowCount = excel.getRowCount(sheetName); int colcount =
 * excel.getColumnCount(sheetName);
 * 
 * Object[][] data = new Object[rowCount - 1][colcount];
 * 
 * for (int row = 2; row <= rowCount; row++) {
 * 
 * for (int col = 0; col < colcount; col++)
 * 
 * {
 * 
 * data[row - 2][col] = excel.getCellData(sheetName, col, row);
 * 
 * }
 * 
 * }
 * 
 * return data;
 * 
 * }
 */
 }
 