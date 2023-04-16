package com.github.panarik.appiumProject.tests.base;

import com.github.panarik.appiumProject.controller.AppiumInstance;
import com.github.panarik.appiumProject.model.screens.SignIn;
import com.github.panarik.appiumProject.model.screens.main.MainScreen;
import com.github.panarik.appiumProject.model.screens.main.mobileShopping.MobileShopping;
import com.github.panarik.appiumProject.model.screens.main.mobileShopping.MobileShoppingAndroid;
import com.github.panarik.appiumProject.model.screens.main.mobileShopping.MobileShoppingIOS;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import static com.github.panarik.appiumProject.controller.AppiumInstance.log;

public class BaseTestClass {

    protected SignIn signIn;
    protected MainScreen main;
    protected MobileShopping mobileShopping;

    private final AppiumInstance appium = new AppiumInstance();

    @Parameters({"platformName", "udid"})
    @BeforeTest
    public void start(String platformName, String udid) {
        log.info(String.format("Appium setup: %s", platformName));
        appium.setup(platformName, udid);
        setupScreens(platformName);
    }

    @AfterTest
    public void shutdown() {
        appium.stop();
    }

    private void setupScreens(String osName) {
        this.main = new MainScreen();
        this.signIn = new SignIn();
        if (osName.equals("ANDROID")) mobileShopping = new MobileShoppingAndroid();
        else mobileShopping = new MobileShoppingIOS();
        log.info("Screens is ready.");
    }

}
