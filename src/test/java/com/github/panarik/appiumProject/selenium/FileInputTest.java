package com.github.panarik.appiumProject.selenium;

import com.github.panarik.appiumProject.selenium.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;

public class FileInputTest extends BaseTest {

    @BeforeEach
    public void init() {
        driver.get("https://mdbootstrap.com/docs/b4/jquery/forms/file-input");
    }



}
