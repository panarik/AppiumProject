package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.base.MobileItem;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import static com.github.panarik.appiumProject.controller.AppiumInstance.controller;

public class Controller {

    public MobileElement getElement(MobileItem mobileItem) {
        return (MobileElement) controller.get().driver.findElement(By.xpath(mobileItem.getLocatorBody()));
    }

    protected void click(MobileItem mobileItem) {
        try {
            controller.get().driver.findElement(mobileItem.getLocatorType(), mobileItem.getLocatorBody()).click();
        } catch (NoSuchElementException e) {
            failAfterWaiting(mobileItem);
        }
    }

    protected void waitForElementSleep(MobileItem item, int seconds) {
        for (int s = 0; s < seconds + 1; s++) {
            try {
                controller.get().driver.findElement(item.getLocatorType(), item.getLocatorBody());
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
