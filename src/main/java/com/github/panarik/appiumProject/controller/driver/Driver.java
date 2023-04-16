package com.github.panarik.appiumProject.controller.driver;

import org.openqa.selenium.WebDriver;

/**
 * This is optional feature. Driver can be universal with android and iOS and another platforms.
 *
 * @param <T> {@link io.appium.java_client.android.AndroidDriver} or {@link io.appium.java_client.ios.IOSDriver}
 */
public class Driver<T extends WebDriver> {

    private final T driver; //Android or iOS driver

    public Driver(T typeDriver) {
        this.driver = typeDriver;
    }

    public T getDriver() {
        return driver;
    }
}
