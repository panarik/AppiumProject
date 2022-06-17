package com.github.panarik.appiumProject.tests.base;

public class TestScenarios extends BaseTestClass {

    protected void openMainMenu() {
        signIn.onDisplay();
        signIn.openMainScreen();
        main.onDisplay();
    }

}
