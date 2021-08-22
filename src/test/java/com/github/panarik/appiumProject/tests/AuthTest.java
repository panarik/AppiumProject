package com.github.panarik.appiumProject.tests;

import com.github.panarik.appiumProject.pages.AuthPage;
import org.testng.annotations.Test;

public class AuthTest {

    @Test
    public void appTest() {
        AuthPage authPage = new AuthPage();
        authPage.sign_in_without_auth.click();
    }
}
