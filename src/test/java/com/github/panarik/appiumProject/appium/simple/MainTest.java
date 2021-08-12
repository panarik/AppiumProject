package com.github.panarik.appiumProject.appium.simple;

import com.github.panarik.appiumProject.appium.simple.util.SetupDevice;
import org.testng.Assert;

import static com.github.panarik.appiumProject.appium.simple.screen.LogInScreen.onboardingScenario;
import static com.github.panarik.appiumProject.appium.simple.screen.MainMenu.mainMenu;

public class MainTest {


    public static void main(String[] args) {
        //сетапим девайс
        SetupDevice.redmi4X();

        //Онбординг
        onboardingScenario();

        //Главный экран
        Assert.assertTrue(mainMenu.isDisplayed()); //меню главного экрана
    }


}
