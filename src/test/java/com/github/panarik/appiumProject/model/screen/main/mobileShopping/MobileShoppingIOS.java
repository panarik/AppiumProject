package com.github.panarik.appiumProject.model.screen.main.mobileShopping;

import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import com.github.panarik.appiumProject.model.screen.BaseScreen;
import io.qameta.allure.Step;

/**
 * Class of screen 'Mobile shopping' for iOS.
 */
public class MobileShoppingIOS extends BaseScreen implements MobileShopping {

    private final MobileItem BACK_TO_MAIN_MENU_BUTTON = new MobileItem(
            "Toolbar -> Back to Main menu button",
            new Locator("", "//XCUIElementTypeNavigationBar[@name='Main menu']"));

    @Step("Checking the '" + SCREEN_NAME + "' screen.")
    public void onDisplay() {
        log.info("Checking the '" + SCREEN_NAME + "' screen.");
        verifyItem(BACK_TO_MAIN_MENU_BUTTON, this);
    }

}
