package com.github.panarik.appiumProject.tests;

import com.github.panarik.appiumProject.tests.base.CommonActions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOne extends CommonActions {

    @Test
    public void testOne() {
        System.out.println("Test");
        Assert.assertTrue(true);

//        signIn
//                .checkScreen()
//                .clickNext();
    }
}
