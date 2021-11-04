package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTest extends BaseTest {

    @BeforeEach
    public void init() {
        driver.get("https://www.avito.ru");
    }

    @Test
    public void getText() {
        goToTransport();
        WebElement score = driver.findElement(By.xpath("//span[@class='page-title-count-oYIga']"));
        String s = score.getText();
        System.out.println(s);
        Assertions.assertTrue(s.length()>5);
    }

    @Test
    public void getStyles() {
        WebElement stuff = driver.findElement(By.xpath("//a[text()='Личные вещи']"));
        String stuffColor = stuff.getCssValue("color");
        System.out.println(stuffColor);
        Assertions.assertEquals(stuffColor, "rgba(0, 156, 240, 1)");
    }

}
