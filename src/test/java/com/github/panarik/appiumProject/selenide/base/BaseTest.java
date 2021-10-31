package com.github.panarik.appiumProject.selenide.base;

import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


public class BaseTest {

    @BeforeEach
    public void init() {
        open("https://www.google.com/");
        element(byName("q")).setValue("selenide").pressEnter();
    }

}
