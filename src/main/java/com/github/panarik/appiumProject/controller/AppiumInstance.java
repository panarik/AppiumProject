package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.tools.Log;
import com.github.panarik.appiumProject.tools.configs.DriverCreator;
import com.github.panarik.appiumProject.tools.configs.capabilities.IOSOptionsBuilder;
import com.github.panarik.appiumProject.tools.configs.capabilities.OptionalsHolder;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AppiumInstance {

    static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>(); // Common driver.
    private final Log log = new Log();

    public void setup(String platformName, String udid) {
        createAppiumDriver(new IOSOptionsBuilder(udid).build());
        configureAppium();
    }

    private void createAppiumDriver(OptionalsHolder optionalsHolder) {
        WebDriver driver;
        driver = new DriverCreator(optionalsHolder).create();
        DRIVER.set(driver);
    }

    private void configureAppium() {
        DRIVER.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void stop() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            log.info("Driver has shutdown.");
        } else log.info("Driver already shutdown.");
    }

}
