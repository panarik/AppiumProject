package com.github.panarik.appiumProject.model.screen.signIn;

import com.github.panarik.appiumProject.controller.AndroidController;
import com.github.panarik.appiumProject.model.base.MobileItem;

/**
 * Класс в котором реализована работа экрана 'SignIn' для Android.
 */
public class SignInAndroid extends AndroidController implements SignIn {

    private final MobileItem ITEM = new MobileItem("Поле", "XPATH", "//Button");

    @Override
    public void checkScreen() {
        getElement(ITEM);
    }
}
