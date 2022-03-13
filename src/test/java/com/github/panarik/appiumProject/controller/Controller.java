package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.base.MobileItem;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import static com.github.panarik.appiumProject.controller.AppiumInstance.getDriver;

/**
 * Класс, в котором собраны все методы для запуска теста на Android i iOS.
 */
public class Controller {
    
    public MobileElement getElement(MobileItem mobileItem) {
        return (MobileElement) getDriver().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody());
    }

    /**
     * Метод делает клик на {@link MobileItem}
     *
     * @param mobileItem
     */
    protected void click(MobileItem mobileItem) {
        try {
            getDriver().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
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
                getDriver().driver.findElement(item.getLocatorType(), item.getLocatorBody());
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

    protected void failAfterWaiting(MobileItem mobileitem) {
        Assert.fail("Элемент " + mobileitem.getName() + " не найден.");
    }

}
