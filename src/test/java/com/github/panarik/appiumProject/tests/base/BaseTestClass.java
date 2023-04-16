package com.github.panarik.appiumProject.tests.base;

import com.github.panarik.appiumProject.controller.AppiumBuilder;
import com.github.panarik.appiumProject.model.screens.SignIn;
import com.github.panarik.appiumProject.model.screens.main.MainScreen;
import com.github.panarik.appiumProject.model.screens.main.mobileShopping.MobileShopping;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.github.panarik.appiumProject.controller.AppiumBuilder.log;

public class BaseTestClass {

    protected SignIn signIn;
    protected MainScreen main;
    protected MobileShopping mobileShopping;

    private final AppiumBuilder appium = new AppiumBuilder();

    @BeforeTest
    public void start() {
        String osName = "ANDROID";
        log.info(osName + " appium: setup.");
        appium.setup(osName);
        log.info(osName + " appium: ready.");
    }

    @AfterTest
    public void shutdown() {
        appium.stop();
    }

    private void setupScreens() {
        this.main = new MainScreen();
        this.signIn = new SignIn();
    }
    
}
