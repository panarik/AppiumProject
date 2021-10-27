package com.github.panarik.appiumProject.selectors;

import com.github.panarik.appiumProject.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SelectorElement extends BaseTest {

    @Test
    public void selectorElement() {
        //один фильтр
        $("body").should(visible); //body
        $("#main").should(visible); //find by id
        $(".gLFyf.gsfi").should(visible); //find by class name
        $("[role='main']").should(visible); //find by attribute

        //несколько фильтров
        $("#search .g [data-hveid='CCUQAA']"); // фильтры: по id, по классу, по параметру data-hveid
        $("div[class='eKjLze'] div.yuRUbf").should(visible); //фильтры: по классу eKjLze ищем child с классом yuRUbf
        $("div[class='eKjLze'] > div.g").should(visible); //nearest child
//        $("a:not(href^='http')") // href не начинается с http
    }
}
