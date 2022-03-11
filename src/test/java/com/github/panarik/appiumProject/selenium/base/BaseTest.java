package com.github.panarik.appiumProject.selenium.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver; //driver for Selenium tests
    protected WebDriverWait wait;

    @BeforeTest
    public void setup() {
        System.out.println("Setup driver.");
        driver = new DriverBase().setupDriver();
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

    @AfterTest
    public void shutdown(){
        System.out.println("Shutdown driver.");
        driver.quit();
    }
}
