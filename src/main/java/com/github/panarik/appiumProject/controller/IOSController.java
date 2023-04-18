package com.github.panarik.appiumProject.controller;


import com.github.panarik.appiumProject.tools.Log;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;

public class IOSController {

    private final IOSDriver driver;
    private final Log log = new Log();

    public IOSController() {
        WebDriver driver = AppiumInstance.DRIVER.get();
        if (driver instanceof IOSDriver) {
            this.driver = (IOSDriver) driver;
            log.info("IOS driver is ready.");
        } else this.driver = null;
    }

    public void iosAction() {
        log.info(driver.getBatteryInfo().getState().toString());
    }
}
