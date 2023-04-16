package com.github.panarik.appiumProject.model.screens.main.mobileShopping;

import com.github.panarik.appiumProject.model.screens.base.IOSBaseScreen;
import io.qameta.allure.Step;

/**
 * Class of screen 'Mobile shopping' for iOS.
 */
public class MobileShoppingIOS extends IOSBaseScreen implements MobileShopping {

//    private final MobileItem BACK_TO_MAIN_MENU_BUTTON = new MobileItem();

    @Step("Checking the '" + SCREEN_NAME + "' screen.")
    public void onDisplay() {
//        log.info("Checking the '" + SCREEN_NAME + "' screen.");
    }

}
