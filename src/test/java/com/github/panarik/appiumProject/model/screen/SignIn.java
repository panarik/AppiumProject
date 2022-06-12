package com.github.panarik.appiumProject.model.screen;

import com.github.panarik.appiumProject.controller.Controller;
import com.github.panarik.appiumProject.model.base.Locator;
import com.github.panarik.appiumProject.model.base.MobileItem;
import io.qameta.allure.Step;

/**
 * SignIn screen.
 */
public class SignIn extends Controller {

    private final MobileItem SIGN_IN_WITHOUT_AUTH_BUTTON = new MobileItem(
            "Button 'Sign in without auth'",
            Locator.XPATH,
            "//android.widget.Button[@text='ПРОДОЛЖИТЬ БЕЗ РЕГИСТРАЦИИ']");

    /**
     * Verify current screen is open and loaded.
     */
    @Step("Map screen has open.")
    public void onDisplay() {
        log.info("SignIn screen has open.");
        verifyItem(SIGN_IN_WITHOUT_AUTH_BUTTON);
    }

    /**
     * Opening
     */
    @Step("Opening Main screen.")
    public void openMainScreen() {
        log.info("Opening Main screen.");
        click(SIGN_IN_WITHOUT_AUTH_BUTTON);
        new Main().onDisplay();
    }

}
