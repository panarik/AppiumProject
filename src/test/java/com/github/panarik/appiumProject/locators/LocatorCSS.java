package com.github.panarik.appiumProject.locators;

public class LocatorCSS {

    //single
    public static final String TAG_BODY = "body"; //тег body
    public static final String TAG_DIV = "div"; //тег div
    public static final String ID = "#main"; //find by id
    public static final String CLASS = ".gLFyf"; // find by class
    public static final String ATTRIBUTE1 = "[role]"; //find by attribute key
    public static final String ATTRIBUTE2 = "[role='main']"; //find by attribute key and value

    //contains
    public static final String ATTRIBUTE_CONTAINS = "[role*='something']"; //attribute key 'role' contains value 'something'
    public static final String ATTRIBUTE_BEGIN = "[role^='present']"; //attribute key 'role' has begin value 'present'
    public static final String ATTRIBUTE_END = "[role$='some']"; //attribute key 'role' has ending by value 'some'

    //combine
    public static final String CLASS_MANY = ".gLFyf.gsfi"; //className and className
    public static final String ID_CLASS = "#search .g"; //id and className
    public static final String ID_CLASS_ATTRIBUTE1 = "#search .g [data-hveid]"; // фильтры: по id, по классу, по параметру data-hveid
    public static final String ID_CLASS_ATTRIBUTE2 = "#search .g [data-hveid='CAUQAA']"; // фильтры: по id, по классу, по параметру data-hveid
    public static final String CLASS_ATTRIBUTE = ".KxwPGc[data-sfe='true']"; // фильтры: по классу .KxwPGc и параметру data-sfe и значению true

    //not
    public static final String CLASS_NOT = "div:not(.col)"; //список тегов которые не имеют класс "col"
    public static final String ATTRIBUTE_NOT = "a:not(href^='http')"; //список тегов в которых атрибут href не имеют класс "col"

    //child
    public static final String CLASS_CHILD = "div[class='eKjLze'] div.yuRUbf";      //в теге с классом eKjLze ищем тег - любого наследника с классом yuRUbf
    public static final String CLASS_CHILD_NEAREST = "div[class='eKjLze'] > div.g"; //в теге с классом eKjLze ищем тег - прямого наследника с классом yuRUbf

    //list
    public static final String CHILD_LI_FIRST = "ul li:first-child"; // во всех ul вывести список всех ПЕРВЫХ child li во всех
    public static final String CHILD_LI_LAST = "ul li:last-child"; //во всех ul вывести список всех ПОСЛЕДНИХ child li во всех
    public static final String CHILD_LI_2 = "ul li:nth-child(2)"; //во всех ul вывести список всех ВТОРЫХ child li во всех
}
