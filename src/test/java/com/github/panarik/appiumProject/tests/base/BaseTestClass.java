package com.github.panarik.appiumProject.tests.base;

import com.github.panarik.appiumProject.controller.AppiumInstance;
import com.github.panarik.appiumProject.model.base.Configs;
import com.github.panarik.appiumProject.model.screen.SignIn;
import com.github.panarik.appiumProject.model.screen.main.Main;
import com.github.panarik.appiumProject.model.screen.main.mobileShopping.MobileShopping;
import com.github.panarik.appiumProject.model.screen.main.mobileShopping.MobileShoppingAndroid;
import com.github.panarik.appiumProject.model.screen.main.mobileShopping.MobileShoppingIOS;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.github.panarik.appiumProject.controller.Controller.log;

public class BaseTestClass {

    // Set up screens.
    // Add common screens for both platforms.
    protected final SignIn signIn = new SignIn();
    protected final Main main = new Main();

    // Add different screens for each platform.
    protected MobileShopping mobileShopping;

    private final AppiumInstance instance = new AppiumInstance();

    public BaseTestClass() {

        // Initialize screens for each platform.
        switch (Configs.OS) {
            case ("ANDROID") -> mobileShopping = new MobileShoppingAndroid();
            case ("IOS") -> mobileShopping = new MobileShoppingIOS();
        }
    }

    @BeforeTest
    public void start() {
        String osName = Configs.OS;
        log.info(osName + " driver: setup.");
        instance.setup(osName);
        log.info(osName + " driver: ready.");
    }

    @AfterTest
    public void shutdown() {
        instance.stop();
    }

}
