package com.github.panarik.appiumProject.model.screens.main;

import com.github.panarik.appiumProject.model.screens.base.BaseScreen;
import io.qameta.allure.Step;

/**
 * MainScreen screen for both platforms.
 */
public class MainScreen extends BaseScreen {

    private final String SCREEN_NAME = "MainScreen";

//    private final MobileItem ROOT = new MobileItem("Recycle view with root content",
//            new Locator("com.github.panarik.smartFeatures:id/recyclerView", "//XCUIElementTypeNavigationBar[@name='MainScreen menu']"));

    /**
     * Verify current screen is open and loaded.
     */
    @Step("Checking the '" + SCREEN_NAME + "' screen.")
    public void onDisplay() {
        log.info("Checking the '" + SCREEN_NAME + "' screen.");
//        verifyItem(ROOT, this);
    }

}
