package com.github.panarik.appiumProject.selenium.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    protected static WebDriver driver; //driver for Selenium tests

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().getPageLoadTimeout();
    }

    protected void goToTransport() {
        //выбираем категорию "Транспорт"
        WebElement category = driver.findElement(By.xpath("//select[@id='category']"));
        category.click();
        WebElement selectTransport = driver.findElement(By.xpath("//select[@id='category']//option[text()='Транспорт']"));
        selectTransport.click();
        //ждем
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }



    @AfterAll
    public static void shutdown(){
        driver.close();
    }

}
