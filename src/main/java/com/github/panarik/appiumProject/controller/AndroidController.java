package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.tools.Log;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class AndroidController {

    private final AndroidDriver driver;
    private final Log log = new Log();

    public AndroidController() {
        WebDriver driver = AppiumInstance.DRIVER.get();
        if (driver instanceof AndroidDriver) {
            this.driver = (AndroidDriver) driver;
            log.info("IOS driver is ready.");
        } else this.driver = null;
    }

    public void androidAction() {
        System.out.println(driver.getBatteryInfo().getState());
    }
}
