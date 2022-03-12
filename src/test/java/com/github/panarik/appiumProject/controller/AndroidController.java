package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.base.MobileItem;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

import static com.github.panarik.appiumProject.controller.AppiumController.getController;

/**
 * Класс, в котором собраны все методы для запуска теста на Android
 */
public class AndroidController extends BaseController {

    AndroidDriver<MobileElement> androidDriver;

    public AndroidController() {
        this.androidDriver = getController().getAndroidDriver();
    }

    public MobileElement getElement(MobileItem mobileItem) {
        return androidDriver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody());
    }

    /**
     * Метод делает клик на {@link MobileItem}
     *
     * @param mobileItem
     */
    protected void click(MobileItem mobileItem) {
        try {
            androidDriver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem);
        }
    }

    /**
     * Кустарное ожидание элемента {@link MobileItem} указанное число секунд.
     * Метод каждую секунду пытается найти элемент.
     *
     * @param item    элемент {@link MobileItem}
     * @param seconds количество секунд
     */
    protected void waitForElementSleep(MobileItem item, int seconds) {
        for (int s = 0; s < seconds + 1; s++) {
            try {
                androidDriver.findElement(item.getLocatorType(), item.getLocatorBody());
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
