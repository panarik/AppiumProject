package com.github.panarik.appiumProject.model.screen.signIn;

import com.github.panarik.appiumProject.controller.Controller;
import com.github.panarik.appiumProject.model.base.MobileItem;

/**
 * Класс в котором реализована работа экрана 'SignIn' для Android.
 */
public class SignIn extends Controller {

    private final MobileItem ITEM = new MobileItem("Поле", "XPATH", "//Button");

    public SignIn checkScreen() {
        getElement(ITEM);
        return this;
    }

    public void clickNext() {
        click(ITEM);
    }
}
