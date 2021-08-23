package com.github.panarik.appiumProject.util;

import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;

public class Check {

    public static void isDisplayed(AndroidElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    public static void equals(AndroidElement element, String text) {
        Assert.assertEquals(element.getText(), text);
    }

}
