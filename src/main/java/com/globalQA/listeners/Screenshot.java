package com.globalQA.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart : "+result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess : "+result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure : "+result.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped : ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailure : ");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout : ");
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart : ");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish : ");
	}

}
