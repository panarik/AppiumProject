package com.github.panarik.appiumProject.controller;

import io.appium.java_client.ios.IOSDriver;

public class IOSController extends WebController {

    private final IOSDriver driver;

    public IOSController() {
        super(AppiumBuilder.DRIVER.get());
        if (AppiumBuilder.DRIVER.get() instanceof IOSDriver) {
            driver = (IOSDriver) AppiumBuilder.DRIVER.get();
            log.info("Android driver is ready.");
        } else driver = null;
    }
}
