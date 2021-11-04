package com.github.panarik.appiumProject.locators;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsXPath {

    //$x("//html/body/")
    //html/body

    //single
    public static String body = "//html/body";
    public static String ID = "//div[@id ='someId']";// find div with id
    public static String EXACT_TEXT = "//h3[text()='Some text']"; // h3 with text 'Some text'
    public static String CLASS_NUMBER = "//div[@class='g'][6]"; // 6-th div with class 'g'
    public static String CLASS_LAST = "//div[@class='g'][last()]"; // last div with class 'g'
    public static String CONTAINS_TEXT = "//h3[(contains(text(),'Some text')]"; // h3 contains text 'Some text'
    public static String CONTAINS_CLASS = "//h3[contains(@class,'SomeClass')]"; // h3 contains class 'SomeClass

    //combine
    public static String COMBINE_2 = "//div[@class='g'][3]//a[@class='SomeClass']"; // search a[@class='SomeClass'] INSIDE div[@class='g'][3]
    public static String COMBINE_3 = "//div[@class='g'][3]//a[@class='SomeClass'//br[@class='SomeClass']"; // search //br[@class='SomeClass'] INSIDE a[@class='SomeClass'] INSIDE div[@class='g'][3]

    //go to parent
    public static String TO_PARENT_1 = "//span[text()='Владелец: ']/../../../div[2]"; //из первого child с помощью '/..' поднимаемся к родителю. Далее перемещаемся к второму child с помощью /div[2]
    public static String TO_PARENT_2 = "//span[text()='Владелец: ']/parent::div/parent::div/parent::div/div[2]"; //из первого child с помощью '/parent::div' поднимаемся к родителю. Далее перемещаемся к второму child с помощью /div[2]

    //go to sibling
    public static String TO_SIBLING = "//span[text()='Владелец: ']/parent::div/parent::div/following-sibling::div/div/span"; //из первого child с помощью 'following-sibling::div' перемещаемся к соседнему 'div'. Далее спускаемся вниз с помощью '/div/span'
}
