package com.ProjectExtentReport;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testProject.utilities.TestUtil;

public class ExtentListener implements ITestListener {

	
	String filename="test.html";
	ExtentReports extent = ExtentManager.getInstance(".\\target\\" + filename);
	
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent
				.createTest(result.getTestClass().getName() + "   @TestCase : " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(methodname, ExtentColor.GREEN);
		test.pass(m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TestUtil.Screenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String methodname = result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(methodname, ExtentColor.RED);
		test.fail(m);
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.screenshotpath).build());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		Markup m = MarkupHelper.createLabel(methodname, ExtentColor.AMBER);
		test.skip(m);
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		//
		extent.flush();
	}

}
