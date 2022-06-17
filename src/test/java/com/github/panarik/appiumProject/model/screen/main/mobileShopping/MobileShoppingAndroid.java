package com.github.panarik.appiumProject.model.screen.main.mobileShopping;

import com.github.panarik.appiumProject.model.screen.BaseScreen;
import io.qameta.allure.Step;

/**
 * Class of screen 'Mobile shopping' for Android.
 */
public class MobileShoppingAndroid extends BaseScreen implements MobileShopping {

    @Step("Checking the '" + SCREEN_NAME + "' screen.")
    public void onDisplay() {
        log.info("Checking the '" + SCREEN_NAME + "' screen.");
    }
}
