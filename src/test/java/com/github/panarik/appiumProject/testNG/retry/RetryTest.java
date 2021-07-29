package com.github.panarik.appiumProject.testNG.retry;

import com.github.panarik.appiumProject.util.Retry;
import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class RetryTest {

    @Test (retryAnalyzer = Retry.class, groups = {"regression"})
    public void test1() {
        System.out.println("Test1");
        Assert.fail();
    }
}



