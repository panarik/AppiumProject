package com.github.panarik.appiumProject;


import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class SimpleTest {

    @BeforeEach
    public void init() {
        open("https://www.google.com/");
        element(byName("q")).setValue("selenide").pressEnter();
    }


    @Test
    public void selectors() {
        $("body").should(visible); //body
        $("#main").should(visible); //find by id
        $(".gLFyf.gsfi").should(visible); //find by class name
        $("[role='main']"); //find by attribute
        $("div[class='eKjLze'] div.yuRUbf").shouldHave(visible); //child
//        $("a:not(href^='http')") // href не начинается с http


    }

    @Test
    public void matchers() {
        $(".Q8LRLc").shouldHave(matchText("Россия")); //match
        $(".mfMhoc").shouldHave(text("запросы")); //contains
//        $(".LC20lb.DKV0Md").shouldHave(selectedText("Selenide: лаконичные и стабильные UI тесты на Java")); //has selected
//        $(".yuRUbf").shouldHave(href("https://selenide.org"));
    }

    @Test
    public void elements_test() {
        ElementsCollection result = elements("#search .g");
        result  .shouldHave(sizeGreaterThanOrEqual(9))
                .first().shouldHave(text("Selenide: лаконичные и стабильные UI тесты на Java"));
        result.first().find(".r>a").click();

        Wait().until(titleIs("Selenide"));
    }

}
