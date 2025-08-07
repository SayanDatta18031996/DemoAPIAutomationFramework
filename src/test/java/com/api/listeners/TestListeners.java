package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
	private static Logger logger=LogManager.getLogger(TestListeners.class);
	public void onStart(ITestResult result) {
		logger.info("Test Suite Started...");
	}
	public void onTestStart(ITestResult result) {
		logger.info("Test Started!! "+result.getMethod().getMethodName());
	}
	public void onTestSuccess(ITestResult result) {
		logger.info("Test case Passed!! "+result.getMethod().getMethodName());
		logger.info("Description!! "+result.getMethod().getDescription());
	}
	public void onTestFailure(ITestResult result) {
		logger.error("Failed!! "+result.getMethod().getMethodName());
	}
	public void onTestSkipped(ITestResult result) {
		logger.error("Skipped!! "+result.getMethod().getMethodName());
	}
	public void onFinish(ITestResult result) {
		logger.info("Suite complete!!! "+result.getMethod().getMethodName());
	}
}
