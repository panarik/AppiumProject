package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.tests.base.BaseTestClass;
import com.github.panarik.appiumProject.model.base.MobileItem;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

/**
 * Класс, в котором собраны все методы для запуска теста на Android
 */
public class AndroidController extends BaseTestClass {

    AndroidDriver<MobileElement> androidDriver;

    public AndroidController() {
        this.androidDriver = controller.getAndroidDriver();
    }

    public MobileElement getElement(MobileItem mobileItem) {
        return androidDriver.findElement(mobileItem.getLocatorType(), mobileItem.getLocator());
    }

    /**
     * Метод делает клик по {@param mobileItem}
     *
     * @param mobileItem
     */
    protected void click(MobileItem mobileItem) {
        try {
            androidDriver.findElement(mobileItem.getLocatorType(), mobileItem.getLocator()).click();
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem);
        }
    }

    /**
     * Метод ожидающий элемента указанное число секунд.
     * Метод каждую секунду пытается найти элемент.
     *
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
