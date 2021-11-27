package com.github.panarik.appiumProject.testNG.appium.simple.util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

public class AndroidBase {

    protected AndroidDriver<MobileElement> androidDriver = (AndroidDriver<MobileElement>) BaseInstance.instance.getDriver();

    protected void click(MobileItem item) {
        androidDriver.findElement(item.getLocatorType(), item.getLocator()).click();
    }


    /**
     * Метод ожидающий элемента указанное число секунд.
     * Метод каждую секунду пытается найти элемент.
     * @param item
     * @param seconds
     */
    protected void waitForElementSleep(MobileItem item, int seconds) {
        for (int s = 0; s < seconds + 1; s++) {
            try {
                androidDriver.findElement(item.getLocatorType(), item.getLocator());
            } catch (NoSuchElementException e) {
                System.out.println("waiting " + s + " seconds for: " + item.getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException interrupt) {
                    interrupt.printStackTrace();
                }
            }
        }
    }

}
