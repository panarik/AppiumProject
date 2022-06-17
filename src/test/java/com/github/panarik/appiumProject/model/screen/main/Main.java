package com.github.panarik.appiumProject.model.screen.main;

import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import com.github.panarik.appiumProject.model.screen.BaseScreen;
import io.qameta.allure.Step;

/**
 * Main screen for both platforms.
 */
public class Main extends BaseScreen {

    private final String SCREEN_NAME = "Main";

    private final MobileItem ROOT = new MobileItem("Recycle view with root content",
            new Locator("com.github.panarik.smartFeatures:id/recyclerView", "//XCUIElementTypeNavigationBar[@name='Main menu']"));

    /**
     * Verify current screen is open and loaded.
     */
    @Step("Checking the '" + SCREEN_NAME + "' screen.")
    public void onDisplay() {
        log.info("Checking the '" + SCREEN_NAME + "' screen.");
        verifyItem(ROOT, this);
    }

}
