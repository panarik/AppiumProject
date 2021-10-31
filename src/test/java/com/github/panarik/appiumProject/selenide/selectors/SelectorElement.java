package com.github.panarik.appiumProject.selenide.selectors;

import com.github.panarik.appiumProject.selenide.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SelectorElement extends BaseTest {

    @Test
    public void selectorElement() {
        //один фильтр
        $("body").should(visible); //body
        $("#main").should(visible); //find by id
        $(".gLFyf.gsfi").should(visible); //find by class name
        $("[role='main']").should(visible); //find by attribute
        $(byText("Картинки")).should(visible); //find by text
        $(byName("q")).should(visible); //find by attribute name
        $(byId("main")).should(visible);//find by attribute id
        $(byClassName("IsZvec")).should(visible); //find by class name (only one class)
        $(byAttribute("role", "main")).should(visible); //find by attribute role

        //несколько фильтров
        $("#search .g [data-hveid]").should(visible); // фильтры: по id, по классу, по параметру data-hveid
//        $("#search .g [data-hveid='CAUQAA']").should(visible); // фильтры: по id, по классу, по параметру data-hveid
        $("div[class='eKjLze'] div.yuRUbf").should(visible); //фильтры: по классу eKjLze ищем child с классом yuRUbf
        $("div[class='eKjLze'] > div.g").should(visible); //nearest child
//        $("a:not(href^='http')") // href не начинается с http
        $("#search").findAll(".g").find(attribute("data-hveid", "CAUQAA")).should(visible); // фильтры: по id, по классу, по параметру data-hveid
    }
}
