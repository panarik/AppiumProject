package com.github.panarik.appiumProject.controller;


import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

import static com.github.panarik.appiumProject.controller.AppiumInstance.log;

public class IOSController {

    private final IOSDriver driver;

    public IOSController() {
        WebDriver driver = AppiumInstance.DRIVER.get();
        if (driver instanceof IOSDriver) {
            this.driver = (IOSDriver) driver;
            log.info("Android driver is ready.");
        } else this.driver = null;
    }

    public void iosAction() {
        log.info(driver.getBatteryInfo().getState().toString());
    }
}
