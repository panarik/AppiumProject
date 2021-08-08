package com.github.panarik.appiumProject.testNG.appium.tests;

import com.github.panarik.appiumProject.testNG.appium.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class TestOne extends BaseClass {

    @Test
    public void TestLogIn() {
        String sign_in_without_auth = "com.github.panarik.smartFeatures:id/sign_in_without_auth";
        String recyclerView = "com.github.panarik.smartFeatures:id/recyclerView";

        driver.findElementById(sign_in_without_auth).click();
        waitForElement(5, recyclerView);
        driver.findElementById(recyclerView).isDisplayed();
    }

    private void waitForElement(int seconds, String elementPath) {
        for (int s = 0; s<seconds+1; s++) {
            try {
                driver.findElementById(elementPath);
            } catch (NoSuchElementException e) {
                System.out.println("waiting "+s+" seconds for: "+elementPath);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interrupt) {
                    interrupt.printStackTrace();
                }
            }
        }
    }


    private boolean isElementPresent(String elementPath) {
        try {
            driver.findElementById(elementPath);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
