package com.github.panarik.appiumProject.model.screen.signIn;

import com.github.panarik.appiumProject.controller.IOSController;
import com.github.panarik.appiumProject.model.base.MobileItem;

/**
 * Класс в котором реализована работа экрана 'SignIn' для iOS.
 */
public class SignInIOS extends IOSController implements SignIn {

    private final MobileItem ITEM = new MobileItem("Поле", "XPATH", "/UIAScrollView");


    public void checkScreen() {
        getElement(ITEM);
    }

}
