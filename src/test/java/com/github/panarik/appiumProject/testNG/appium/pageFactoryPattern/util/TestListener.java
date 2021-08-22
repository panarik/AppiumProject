package com.github.panarik.appiumProject.testNG.appium.pageFactoryPattern.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        SetupDevice.setup();
    }
}
