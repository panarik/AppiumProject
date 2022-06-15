package com.github.panarik.appiumProject.model.screen;

import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import io.qameta.allure.Step;

/**
 * Main screen.
 */
public class Main extends BaseScreen {

    private final String SCREEN_NAME = "Main";

    private final MobileItem ROOT = new MobileItem("Recycle view with root content",
            new Locator("com.github.panarik.smartFeatures:id/recyclerView", "//XCUIElementTypeNavigationBar[@name='Main menu']"));

    /**
     * Verify current screen is open and loaded.
     */
    @Step("Opening the Main screen.")
    public void onDisplay() {
        log.info("Opening the Main screen.");
        verifyItem(ROOT, this);
    }

}
