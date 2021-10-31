package com.github.panarik.appiumProject.selenide.selectors;

import com.github.panarik.appiumProject.selenide.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.github.panarik.appiumProject.locators.LocatorCSS.*;

public class SelectorElement extends BaseTest {

    @Test
    public void selectorElement() {
        //один фильтр CSS
        $(BODY).should(visible);
        $(ID).should(visible);
        $(CLASS_MANY).should(visible);
        $(ATTRIBUTE).should(visible);

        $(byId("main")).should(visible);//find by attribute id
        $(byClassName("IsZvec")).should(visible); //find by class name (only one class)
        $(byName("q")).should(visible); //find by attribute name
        $(byAttribute("role", "main")).should(visible); //find by attribute role
        $(byText("Картинки")).should(visible); //find by text

        //несколько фильтров
        $("#search .g [data-hveid]").should(visible); // фильтры: по id, по классу, по параметру data-hveid
//        $("#search .g [data-hveid='CAUQAA']").should(visible); // фильтры: по id, по классу, по параметру data-hveid
        $("div[class='eKjLze'] div.yuRUbf").should(visible); //фильтры: по классу eKjLze ищем child с классом yuRUbf
        $("div[class='eKjLze'] > div.g").should(visible); //nearest child
        $("a:not(href^='http')"); // href не начинается с http
        $("#search").findAll(".g").find(attribute("data-hveid", "CAUQAA")).should(visible); // фильтры: по id, по классу, по параметру data-hveid
    }
}
