package com.github.panarik.appiumProject.model.screen;

import com.github.panarik.appiumProject.controller.Controller;
import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import io.qameta.allure.Step;

/**
 * Main screen.
 */
public class Main extends Controller {

    private final MobileItem ROOT = new MobileItem(
            "Recycle view with root content",
            new Locator("com.github.panarik.smartFeatures:id/recyclerView", "//XCUIElementTypeNavigationBar[@name='Main menu']"));

    /**
     * Verify current screen is open and loaded.
     */
    @Step("Main screen has open.")
    public void onDisplay() {
        log.info("Main screen has open.");
        verifyItem(ROOT);
    }

}
