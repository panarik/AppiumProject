package com.github.panarik.appiumProject.tests;

import com.github.panarik.appiumProject.pages.MainPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MainTest {

    private static MainPage main;

    @BeforeAll
    public static void setup() {
        main = new MainPage();
    }


    @Test
    public void search() {
        main.search("test");
    }
}
