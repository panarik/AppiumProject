package com.github.panarik.appiumProject.model.screens.main.mobileShopping;

import com.github.panarik.appiumProject.model.screens.base.AndroidBaseScreen;
import io.qameta.allure.Step;

/**
 * Class of screen 'Mobile shopping' for Android.
 */
public class MobileShoppingAndroid extends AndroidBaseScreen implements MobileShopping {

    @Step("Checking the '" + SCREEN_NAME + "' screen.")
    public void onDisplay() {
//        log.info("Checking the '" + SCREEN_NAME + "' screen.");
    }
}
