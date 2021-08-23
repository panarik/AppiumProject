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

        //1 - Отображение на экране
        //Проверка нативным классом
        Assert.assertTrue(authPage.sign_in_logo.isDisplayed());
        //Проверка кастомным методом
        Check.isDisplayed(authPage.sign_in_logo);

        //2 - Матчинг текста
        //Проверка нативным классом
        Assert.assertEquals(authPage.sign_in_without_auth.getText(), "ПРОДОЛЖИТЬ БЕЗ РЕГИСТРАЦИИ");

        //Клик на By локаторе
        authPage.severalClicks();
        //клик на AndroidElement
        authPage.sign_in_without_auth.click();

    }
}
