package com.github.panarik.appiumProject.util;

import com.github.panarik.appiumProject.driver.DriverAndroid;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {

    public static void click(By element){
        new WebDriverWait(DriverAndroid.getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(element)).click();
    }

    public static void click(int xCoordinates, int yCoordinates) {
        AndroidTouchAction action = new AndroidTouchAction(DriverAndroid.getDriver());
        action
                .tap(PointOption.point(xCoordinates, yCoordinates))
                .release()
                .perform();
    }

    public static void click(AndroidElement element) {
        new WebDriverWait(DriverAndroid.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void swipeTo(String text) {
        DriverAndroid.getDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+text+"\"))"));
    }
}
