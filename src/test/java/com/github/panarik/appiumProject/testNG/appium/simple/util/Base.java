package com.github.panarik.appiumProject.testNG.appium.simple.util;

import org.testng.Assert;

/**
 * Класс с общими методами для iOS и Android.
 */
public class Base {

    protected void failAfterWaiting(MobileItem mobileitem) {
        Assert.fail("Элемент " + mobileitem.getName() + " не найден");
    }

}
