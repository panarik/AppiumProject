package com.github.panarik.appiumProject.selenium.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver; //driver for Selenium tests

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\driver\\chromedriver.exe");
    }



    @AfterAll
    public static void shutdown(){
        driver.close();
    }

}
