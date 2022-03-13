package com.github.panarik.appiumProject.model.screen.signIn;

import com.github.panarik.appiumProject.controller.Controller;
import com.github.panarik.appiumProject.model.base.MobileItem;

public class Menu extends Controller {

    private final MobileItem ITEM = new MobileItem("Поле", "XPATH", "//Button");

    public Menu checkScreen() {
        getElement(ITEM);
        return this;
    }

}
