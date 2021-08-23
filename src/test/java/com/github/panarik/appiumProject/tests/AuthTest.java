package com.github.panarik.appiumProject.tests;

import com.github.panarik.appiumProject.pages.AuthPage;
import com.github.panarik.appiumProject.util.Action;
import com.github.panarik.appiumProject.util.Check;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest {

    @Test
    public void appTest() {
        AuthPage authPage = new AuthPage();

        //МАТЧЕРЫ
        //1 - Отображение на экране
        Assert.assertTrue(authPage.sign_in_logo.isDisplayed()); //Проверка нативным классом
        Check.isDisplayed(authPage.sign_in_logo); //Проверка кастомным методом
        //2 - Матчинг текста
        Assert.assertEquals(authPage.sign_in_without_auth.getText(), "ПРОДОЛЖИТЬ БЕЗ РЕГИСТРАЦИИ"); //Проверка нативным классом

        //ACTIONS
        //1 - нативные
        authPage.chat_toggleSingUpTextView.click(); //клик на AndroidElement
        //2 - кастомные
        Action.click(authPage.chat_toggleSingUpTextView);
        Action.click(500, 500); //клик по координатам
        authPage.chat_toggleSingUpTextView.click();
        //3 - сценарий на базовом экране
//        authPage.severalClicks(); //Клик на By локаторах
        authPage.onboardingScenario();


    }
}
