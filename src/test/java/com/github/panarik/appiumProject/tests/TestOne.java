package com.github.panarik.appiumProject.tests;

import com.github.panarik.appiumProject.tests.base.TestScenarios;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestOne extends TestScenarios {

    @BeforeClass
    public void init() {
    }

    @Test
    public void openMenu() {

        // Step 1: Open Main menu.
        openMainMenu();
    }

    @Test
    public void verifyShoppingScreen() {

        // Step 1: Open 'Main menu'.
        openMainMenu();

        // Step 2: Open 'Mobile shopping'.
        mobileShopping.onDisplay();
    }

    @Test
    public void fail() {
        Assert.fail("Fail message");
    }

}
