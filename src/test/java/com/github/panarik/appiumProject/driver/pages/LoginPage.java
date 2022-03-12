package com.github.panarik.appiumProject.driver.pages;

import com.github.panarik.appiumProject.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class LoginPage {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("");
    }

    By usernameInput = By.id("user");
    By passwordInput = By.id("pass");
    By submitBtn = By.id("submit");
    By displayNameLnk = By.id("userDisplayName");

    public void login(User user) {
        driver.findElement(usernameInput).sendKeys(user.getUsername());
        driver.findElement(passwordInput).sendKeys(user.getPassword());
        driver.findElement(submitBtn).click();
    }

    public String getDisplayName() {
        return driver.findElement(displayNameLnk).getText();
    }

}
