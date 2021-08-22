package com.github.panarik.appiumProject.testNG.appium.simple.util;

import org.openqa.selenium.NoSuchElementException;

import static com.github.panarik.appiumProject.testNG.appium.simple.BaseClass.driver;

public class Util {

    public static void waitForElement(int seconds, String elementPath) {
        for (int s = 0; s < seconds + 1; s++) {
            try {
                driver.findElementById(elementPath);
            } catch (NoSuchElementException e) {
                System.out.println("waiting " + s + " seconds for: " + elementPath);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interrupt) {
                    interrupt.printStackTrace();
                }
            }
        }
    }

}
