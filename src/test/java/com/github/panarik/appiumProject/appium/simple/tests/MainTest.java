package com.github.panarik.appiumProject.appium.simple.tests;

import com.github.panarik.appiumProject.appium.simple.util.SetupDevice;
import org.testng.Assert;

import static com.github.panarik.appiumProject.appium.simple.pages.LogInScreen.onboardingScenario;
import static com.github.panarik.appiumProject.appium.simple.pages.MainMenu.mainMenu;

public class MainTest {


    public static void main(String[] args) {
        //сетапим девайс
        SetupDevice.setup();

        //Онбординг
        onboardingScenario();

        //Главный экран
        Assert.assertTrue(mainMenu.isDisplayed()); //меню главного экрана
    }


}
