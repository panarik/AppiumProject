package com.github.panarik.appiumProject.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//

import java.util.List;

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
        WebElement body = driver.findElement(By.cssSelector("body")); //по тегу
        WebElement navBar = driver.findElement(By.cssSelector("#gb")); //по id
        WebElement navBarClass = driver.findElement(By.cssSelector(".LX3sZb")); //по классу
        WebElement topperClass = driver.findElement(By.cssSelector(".o3j99.LLD4me.LS8OJ")); //по классу
        WebElement topperClass2 = driver.findElement(By.cssSelector(".KxwPGc[data-sfe='true']")); //по классу и значению параметра
        WebElement input2 = driver.findElement(By.cssSelector("[aria-label='Найти']")); //по значению параметра
        List<WebElement> role = driver.findElements(By.cssSelector("[role]")); //список по параметру
        List<WebElement> divRole = driver.findElements(By.cssSelector("div[role]")); //список тегов с данным параметром
        List<WebElement> divRoleFirst = driver.findElements(By.cssSelector("div[role^='present']")); //список тегов со значением параметра начинаются на i
        List<WebElement> divRoleLast = driver.findElements(By.cssSelector("div[role$='ink']")); //список тегов со значением параметра заканчиваются на ink
        List<WebElement> divNotClass = driver.findElements(By.cssSelector("div:not(.col)")); //список тегов которые не имеют класс "col"


        Assertions.assertTrue(input.isDisplayed());
        Assertions.assertTrue(input2.isDisplayed());
        Assertions.assertTrue(body.isDisplayed());
        Assertions.assertTrue(navBar.isDisplayed());
        Assertions.assertTrue(navBarClass.isDisplayed());
        Assertions.assertTrue(topperClass.isDisplayed());

        input2.sendKeys("12345");
        input2.sendKeys(Keys.ENTER);
    }

    @AfterAll
    public static void shutdown(){
        driver.close();
    }
}
