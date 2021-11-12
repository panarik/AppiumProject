package com.github.panarik.appiumProject.util;

import com.github.panarik.appiumProject.driver.DriverAndroid;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    public static void second(int seconds) {
        try {
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void element(int seconds, String elementPath) {
        for (int s = 0; s < seconds + 1; s++) {
            try {
                AppiumDriver driver = DriverAndroid.getDriver();
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

    public static void element(By element){
        new WebDriverWait(DriverAndroid.getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(element));
    }





}
