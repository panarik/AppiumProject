package com.github.panarik.appiumProject.testNG.appium.simple.tests;

import com.github.panarik.appiumProject.testNG.appium.simple.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import static com.github.panarik.appiumProject.testNG.appium.simple.util.Util.waitForElement;

public class TestOne extends BaseClass {

    @Test
    public void TestLogIn() {
        String sign_in_without_auth = "com.github.panarik.smartFeatures:id/sign_in_without_auth";
        String recyclerView = "com.github.panarik.smartFeatures:id/recyclerView";

        driver.findElementById(sign_in_without_auth).click();
        waitForElement(5, recyclerView);
        driver.findElementById(recyclerView).isDisplayed();
    }
}
