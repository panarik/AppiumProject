package com.github.panarik.appiumProject.driver;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class AppListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        AppFactory.setup();
    }
}
