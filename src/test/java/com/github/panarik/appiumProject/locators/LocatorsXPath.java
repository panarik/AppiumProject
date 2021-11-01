package com.github.panarik.appiumProject.locators;

public class LocatorsXPath {

    //$x("//html/body/")
    public static String body = "//html/body";
    public static String DIV_CLASS_NUMBER = "//div[@class='g'][6]"; // 6-th div with class 'g'
    public static String DIV_CLASS_LAST = "//div[@class='g'][last()]"; // last div with class 'g'
    public static String H3_EXACT_TEXT = "//h3[text()='Some text']"; // h3 with text 'Some text'
    public static String H3_CONTAINS_TEXT = "//h3[(contains(text(),'Some text')]"; // h3 contains text 'Some text'
    public static String H3_CONTAINS_CLASS = "//h3[contains(@class,'SomeClass')]"; // h3 contains class 'SomeClass'
}
