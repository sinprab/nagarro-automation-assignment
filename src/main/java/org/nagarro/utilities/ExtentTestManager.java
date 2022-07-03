package org.nagarro.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
	static 	ExtentTest test;

	public static synchronized ExtentTest getTest() {
		//return (ExtentTest) extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName, String desc) {
		test = extent.createTest(testName, desc);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}

}
