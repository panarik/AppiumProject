package com.github.panarik.appiumProject.selectors;

import com.github.panarik.appiumProject.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$$;

public class SelectorCollection extends BaseTest {

    @Test
    public void selectorCollection() {
        $$("#search .g"); //в поле с id search вывести список всех КЛАССОВ g
        $$("ul li:first-child"); // во всех ul вывести список всех ПЕРВЫХ child li во всех
        $$("ul li:last-child"); //во всех ul вывести список всех ПОСЛЕДНИХ child li во всех
        $$("ul li:nth-child(2)"); //во всех ul вывести список всех ВТОРЫХ child li во всех
    }

}
