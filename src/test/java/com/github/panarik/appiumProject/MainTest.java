package com.github.panarik.appiumProject;

import com.github.panarik.appiumProject.screen.LogInScreen;
import com.github.panarik.appiumProject.util.SetupDevice;
import org.testng.Assert;

import static com.github.panarik.appiumProject.screen.LogInScreen.onboardingScenario;
import static com.github.panarik.appiumProject.screen.MainMenu.mainMenu;

public class MainTest {


    public static void main(String[] args) {
        SetupDevice.redmi4X(); //сетапим девайс

        //Онбординг
        onboardingScenario();

        //Главный экран
        Assert.assertTrue(mainMenu.isDisplayed()); //меню главного экрана

    }


}
