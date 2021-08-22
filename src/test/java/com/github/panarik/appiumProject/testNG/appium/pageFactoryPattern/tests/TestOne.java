package com.github.panarik.appiumProject.testNG.appium.pageFactoryPattern.tests;

import com.github.panarik.appiumProject.testNG.appium.pageFactoryPattern.pages.AuthPage;
import com.github.panarik.appiumProject.testNG.appium.pageFactoryPattern.pages.MainPage;
import com.github.panarik.appiumProject.testNG.appium.pageFactoryPattern.pages.ShopPage;
import org.testng.annotations.Test;

public class TestOne {

    @Test
    public void appTest() throws InterruptedException {

        AuthPage authPage = new AuthPage();
        MainPage mainPage = new MainPage();
        ShopPage shopPage = new ShopPage();

        authPage.sign_in_without_auth.click();
        Thread.sleep(1000);
        mainPage.ViewShop.click();
        Thread.sleep(1000);
        shopPage.goodsImage.isDisplayed();

    }

}
