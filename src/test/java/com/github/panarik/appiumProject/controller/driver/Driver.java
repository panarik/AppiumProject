package com.github.panarik.appiumProject.controller.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * This is optional feature. Driver can be universal with android and iOS.
 * @param <T> {@link io.appium.java_client.android.AndroidDriver} or {@link io.appium.java_client.ios.IOSDriver}
 */
public class Driver<T extends AppiumDriver<MobileElement>> {

    public T driver; //Android or iOS driver

    public Driver(T typeDriver) {
        this.driver = typeDriver;
    }

}
