package com.github.panarik.appiumProject.controller;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import static com.github.panarik.appiumProject.controller.AppiumBuilder.log;

public class AndroidController {

    private final AndroidDriver driver;

    public AndroidController() {
        WebDriver driver = AppiumBuilder.DRIVER.get();
        if (driver instanceof AndroidDriver) {
            this.driver = (AndroidDriver) driver;
            log.info("IOS driver is ready.");
        } else this.driver = null;
    }

    public void androidAction() {
        System.out.println(driver.getBatteryInfo().getState());
    }
}
