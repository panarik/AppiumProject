package com.github.panarik.appiumProject;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class SimpleTest {

    @BeforeEach
    public void init() {
        open("https://www.google.com/");
    }

    @Test
    public void logo_visible() {
        Assertions.assertTrue(element(byClassName("lnXdpd")).isDisplayed(), "Google logo has not found by className lnXdpd");
        Assertions.assertTrue(element(byClassName("gb_f")).isDisplayed(), "Google logo has not found by className gb_f");}

    @Test
    public void search_test() {
        element(byName("q")).setValue("selenide").pressEnter();
        elements("#search .g").shouldHave(size(11));
    }

}
