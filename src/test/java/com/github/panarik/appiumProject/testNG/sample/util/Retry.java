package com.github.panarik.appiumProject.testNG.sample.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int actualRetry = 0;

    @Override
    public boolean retry(ITestResult result) {
        final int MAX_RETRY = 3;
        if (actualRetry< MAX_RETRY) {
            actualRetry++;
            return true;
        }
        else return false;
    }
}