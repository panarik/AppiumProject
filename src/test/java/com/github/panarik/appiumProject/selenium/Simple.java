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
        input.sendKeys("java");
        input.sendKeys(Keys.ENTER);

        WebElement body = driver.findElement(By.cssSelector(TAG_BODY)); //по тегу
        WebElement navBar = driver.findElement(By.cssSelector(ID)); //по id
        WebElement navBarClass = driver.findElement(By.cssSelector(CLASS)); //по классу
        WebElement topperClass = driver.findElement(By.cssSelector(CLASS_MANY)); //по классам
        WebElement topperClass2 = driver.findElement(By.cssSelector(CLASS_ATTRIBUTE)); //по классу и значению параметра
        WebElement input2 = driver.findElement(By.cssSelector(ATTRIBUTE2)); //по значению параметра
        List<WebElement> role = driver.findElements(By.cssSelector(ATTRIBUTE1)); //список по параметру
        List<WebElement> divRole = driver.findElements(By.cssSelector(DIV_ATTRIBUTE)); //список тегов с данным параметром
        List<WebElement> divRoleFirst = driver.findElements(By.cssSelector(TAG_DIV_ATTRIBUTE_BEGIN)); //список тегов со значением параметра начинаются на present
        List<WebElement> divRoleLast = driver.findElements(By.cssSelector(TAG_DIV_ATTRIBUTE_END)); //список тегов со значением параметра заканчиваются на ink
        List<WebElement> divNotClass = driver.findElements(By.cssSelector(CLASS_NOT)); //список тегов которые не имеют класс "col"


        Assertions.assertTrue(input.isDisplayed());
        Assertions.assertTrue(input2.isDisplayed());
        Assertions.assertTrue(body.isDisplayed());
        Assertions.assertTrue(navBar.isDisplayed());
        Assertions.assertTrue(navBarClass.isDisplayed());
        Assertions.assertTrue(topperClass.isDisplayed());


    }

    @AfterAll
    public static void shutdown(){
        driver.close();
    }
}
