package com.github.panarik.appiumProject.tests.base;

public class CommonActions extends BaseTestClass {

    protected void openMainMenu() {
        signIn.onDisplay();
        signIn.openMainScreen();
    }

}
