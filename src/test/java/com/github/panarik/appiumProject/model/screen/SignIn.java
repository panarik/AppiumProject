package com.github.panarik.appiumProject.model.screen;

import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import io.qameta.allure.Step;

/**
 * SignIn screen.
 */
public class SignIn extends BaseScreen {

    private final String SCREEN_NAME = "Sign In";

    private final MobileItem SIGN_IN_WITHOUT_AUTH_BUTTON = new MobileItem("Button 'Sign in without auth'",
            new Locator("//android.widget.Button[@text='ПРОДОЛЖИТЬ БЕЗ РЕГИСТРАЦИИ']", "//XCUIElementTypeStaticText[@name='Continue']"));

    /**
     * Verify current screen is open and loaded.
     */
    @Step(SCREEN_NAME + " screen has open.")
    public void onDisplay() {
        log.info(SCREEN_NAME + " screen has open.");
        verifyItem(SIGN_IN_WITHOUT_AUTH_BUTTON, this);
    }

    /**
     * Opening
     */
    @Step("Opening Main screen.")
    public void openMainScreen() {
        log.info("Opening Main screen.");
        click(SIGN_IN_WITHOUT_AUTH_BUTTON, this);
        new Main().onDisplay();
    }

}
