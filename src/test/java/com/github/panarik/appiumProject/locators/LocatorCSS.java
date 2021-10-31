package com.github.panarik.appiumProject.locators;

public class LocatorCSS {

    public static final String BODY = "body"; //body
    public static final String ID = "#main"; //find by id
    public static final String ATTRIBUTE = "[role='main']"; //find by attribute
    public static final String CHILD_LI_FIRST = "ul li:first-child"; // во всех ul вывести список всех ПЕРВЫХ child li во всех
    public static final String CHILD_LI_LAST = "ul li:last-child"; //во всех ul вывести список всех ПОСЛЕДНИХ child li во всех
    public static final String CHILD_LI_SECOND = "ul li:nth-child(2)"; //во всех ul вывести список всех ВТОРЫХ child li во всех

    //комбинирование
    public static final String CLASS_MANY = ".gLFyf.gsfi"; //className and className
    public static final String ID_CLASS = "#search .g"; //id and className
    //ToDo: также сделать статики и поставить их в selenide.selectors.SelectorElement
//    $("#search .g [data-hveid]").should(visible); // фильтры: по id, по классу, по параметру data-hveid
//    //        $("#search .g [data-hveid='CAUQAA']").should(visible); // фильтры: по id, по классу, по параметру data-hveid
//    $("div[class='eKjLze'] div.yuRUbf").should(visible); //фильтры: по классу eKjLze ищем child с классом yuRUbf
//    $("div[class='eKjLze'] > div.g").should(visible); //nearest child
//    $("a:not(href^='http')"); // href не начинается с http
//    $("#search").findAll(".g").find(attribute("data-hveid", "CAUQAA")).should(visible); // фильтры: по id, по классу, по параметру data-hveid

}
