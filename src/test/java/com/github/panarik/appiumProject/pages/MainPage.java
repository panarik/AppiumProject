package com.github.panarik.appiumProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MainPage extends BasePage {

    public WebElement input_searchForm;

    public MainPage() {
        driver.get("https://www.avito.ru/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        input_searchForm = driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
    }

    public void search(String text) {
        input_searchForm.sendKeys(text);
        input_searchForm.sendKeys(Keys.ENTER);
    }
}
