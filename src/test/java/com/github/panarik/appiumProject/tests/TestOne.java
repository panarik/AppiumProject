package com.github.panarik.appiumProject.tests;

import com.github.panarik.appiumProject.tests.base.CommonActions;
import org.testng.annotations.Test;

public class TestOne extends CommonActions {

    @Test
    public void TestLogIn() {
        signIn
                .checkScreen()
                .clickNext();
    }
}
