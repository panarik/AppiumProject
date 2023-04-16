package com.github.panarik.appiumProject.tests.base;

import com.github.panarik.appiumProject.controller.AppiumBuilder;
import com.github.panarik.appiumProject.model.screens.SignIn;
import com.github.panarik.appiumProject.model.screens.main.MainScreen;
import com.github.panarik.appiumProject.model.screens.main.mobileShopping.MobileShopping;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.github.panarik.appiumProject.controller.WebController.log;

public class BaseTestClass {

    // Set up screens.
    // Add common screens for both platforms.
    protected final SignIn signIn = new SignIn();
    protected final MainScreen main = new MainScreen();

    // Add different screens for each platform.
    protected MobileShopping mobileShopping;

    private final AppiumBuilder appium = new AppiumBuilder();

    public BaseTestClass() {

//        // Initialize screens for each platform.
//        switch (Configs.OS) {
//            case ("ANDROID") -> mobileShopping = new MobileShoppingAndroid();
//            case ("IOS") -> mobileShopping = new MobileShoppingIOS();
//        }
    }

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

}
