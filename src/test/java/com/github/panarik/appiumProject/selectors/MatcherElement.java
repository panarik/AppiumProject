package com.github.panarik.appiumProject.selectors;

import com.github.panarik.appiumProject.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MatcherElement extends BaseTest {

    @Test
    public void elementMatcher() {
        $(".Q8LRLc").shouldHave(matchText("Россия")); //match
        $(".mfMhoc").shouldHave(text("запросы")); //contains
//        $(".LC20lb.DKV0Md").shouldHave(selectedText("Selenide: лаконичные и стабильные UI тесты на Java")); //has selected
//        $(".yuRUbf").shouldHave(href("https://selenide.org"));
    }
}
