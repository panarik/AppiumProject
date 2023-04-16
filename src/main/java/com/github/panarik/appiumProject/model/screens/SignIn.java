package com.github.panarik.appiumProject.model.screens;

import com.github.panarik.appiumProject.model.elements.model.Locator;
import com.github.panarik.appiumProject.model.elements.MobileItem;
import com.github.panarik.appiumProject.model.screens.base.BaseScreen;
import com.github.panarik.appiumProject.model.screens.main.MainScreen;
import io.qameta.allure.Step;

/**
 * SignIn screen for both platforms.
 */
public class SignIn extends BaseScreen {

    private final String SCREEN_NAME = "Sign In";

//    private final MobileItem SIGN_IN_WITHOUT_AUTH_BUTTON = new MobileItem("Button 'Sign in without auth'",
//            new Locator("//android.widget.Button[@text='ПРОДОЛЖИТЬ БЕЗ РЕГИСТРАЦИИ']", "//XCUIElementTypeStaticText[@name='Continue']"));

    /**
     * Verify current screen is open and loaded.
     */
    @Step("Checking the '" + SCREEN_NAME + "' screen.")
    public void onDisplay() {
        log.info("Checking the '" + SCREEN_NAME + "' screen.");
//        verifyItem(SIGN_IN_WITHOUT_AUTH_BUTTON, this);
    }

    /**
     * Opening MainScreen screen.
     */
    @Step("Opening MainScreen screen.")
    public void openMainScreen() {
        log.info("Opening MainScreen screen.");
//        click(SIGN_IN_WITHOUT_AUTH_BUTTON, this);
        new MainScreen().onDisplay();
    }

}
