package com.github.panarik.appiumProject.controller;

import io.appium.java_client.android.AndroidDriver;

public class AndroidController extends WebController {

    private final AndroidDriver driver;

    public AndroidController() {
        super(AppiumBuilder.DRIVER.get());
        driver = (AndroidDriver) AppiumBuilder.DRIVER.get();

    }

    public void androidAction() {
        System.out.println(driver.getBatteryInfo().getState());
    }
}
