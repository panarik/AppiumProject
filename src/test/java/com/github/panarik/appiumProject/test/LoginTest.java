package com.github.panarik.appiumProject.test;

import com.github.panarik.appiumProject.driver.pages.LoginPage;
import com.github.panarik.appiumProject.model.Model;
import com.github.panarik.appiumProject.model.User;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    @Test
    public void TC_validLogin() {
        SoftAssert softAssert = new SoftAssert();
        User user = new Model().getUser();
        LoginPage page = new LoginPage();

        page.login(user);
        softAssert.assertEquals(page.getDisplayName(), user.getUsername());
        softAssert.assertAll();
    }

}
