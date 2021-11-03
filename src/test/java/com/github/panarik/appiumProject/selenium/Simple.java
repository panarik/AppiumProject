package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//

import java.time.Duration;
import java.util.List;

import static com.github.panarik.appiumProject.locators.LocatorCSS.*;

public class Simple extends BaseTest {

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
}
