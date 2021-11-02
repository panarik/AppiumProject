package com.github.panarik.appiumProject.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//

import java.util.List;

import static com.github.panarik.appiumProject.locators.LocatorCSS.*;
import static com.github.panarik.appiumProject.locators.LocatorsXPath.*;

public class Simple {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
    }

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void test1() {
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("selenium");
        input.sendKeys(Keys.ENTER);

        //ToDo: ??
//        WebElement resultNumberSix = driver.findElement(By.xpath(TAG_CLASS_NUMBER));
        WebElement body = driver.findElement(By.cssSelector(TAG_BODY)); //по тегу
        List<WebElement> role = driver.findElements(By.cssSelector(ATTRIBUTE1)); //список по параметру
        WebElement className = driver.findElement(By.className("className"));
        WebElement id = driver.findElement(By.id("id"));
        WebElement linkText = driver.findElement(By.linkText("linkText")); //exact text
        WebElement name = driver.findElement(By.name("linkText")); //attribute name
        WebElement tagName = driver.findElement(By.tagName("tagName")); //attribute tagName


        Assertions.assertTrue(input.isDisplayed());
        Assertions.assertTrue(body.isDisplayed());
    }

    @AfterAll
    public static void shutdown(){
        driver.close();
    }
}
