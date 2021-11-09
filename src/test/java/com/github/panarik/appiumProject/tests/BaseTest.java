package com.github.panarik.appiumProject.tests;

import org.junit.jupiter.api.AfterEach;

import static com.github.panarik.appiumProject.pages.BasePage.driver;

public class BaseTest {

    @AfterEach
    public void quit() {
        driver.quit();
    }

}
