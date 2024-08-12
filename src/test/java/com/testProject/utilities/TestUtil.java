package com.testProject.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;

import com.testProject.base.Testbase;

public class TestUtil extends Testbase {

	public static String screenshotname;
	public static String screenshotpath;

	public static void Screenshot() throws IOException {

		Date date = new Date();
		String d = date.toString().replace(":", "_").replace(" ", "_");

		screenshotname = d + "error.jpg";

		screenshotpath = System.getProperty("user.dir") + "\\target\\" + screenshotname;

		File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileHandler.copy(shot, new File(".\\target\\" + screenshotname));

	}
	
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m) {
		String sheetName = m.getName();
		int rowCount = excel.getRowCount(sheetName);
		int colcount = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rowCount - 1][colcount];

		for (int row = 2; row <= rowCount; row++) {

			for (int col = 0; col < colcount; col++)

			{

				data[row - 2][col] = excel.getCellData(sheetName, col, row);

			}

		}

		return data;

	}


}
