package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AttributeTest extends BaseTest {

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://www.avito.ru");
    }

    @Test
    public void firstAttribute() {
        WebElement linkStaff = driver.findElement(By.xpath("//a[text()='Личные вещи']"));
        Assertions.assertEquals(linkStaff.getAttribute("href"), "https://www.avito.ru/moskva/lichnye_veschi");
        Assertions.assertEquals(linkStaff.getAttribute("offsetWidth"), "88");
        Assertions.assertEquals(linkStaff.getAttribute("offsetHeight"), "15");
    }

    @Test
    public void secondAttribute() {
        goToTransport();
        WebElement selectTransport2 = driver.findElement(By.xpath("//select[@id='category']//option[text()='Транспорт']"));
        Assertions.assertEquals(selectTransport2.getAttribute("selected"), "true");
    }
}
