package com.github.panarik.appiumProject.model.screen.signIn;

import com.github.panarik.appiumProject.controller.Controller;
import com.github.panarik.appiumProject.model.base.MobileItem;

public class SignIn extends Controller {

    private final MobileItem ITEM = new MobileItem("Field", "xpath", "//android.widget.Button[@text='SIGN UP']");

    public SignIn checkScreen() {
        getElement(ITEM);
        return this;
    }

    public void clickNext() {
        click(ITEM);
    }
}
