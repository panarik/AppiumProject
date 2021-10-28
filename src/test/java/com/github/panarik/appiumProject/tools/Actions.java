package com.github.panarik.appiumProject.tools;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.panarik.appiumProject.base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Actions {

    @BeforeEach
    public void init() {
        open("https://todomvc.com/examples/emberjs/");
    }

    @Test
    public void actions() {
        SelenideElement search = $(byId("new-todo"));
        SelenideElement info = $(byId("info"));
        search.hover();
        search.click();
        search.doubleClick();
        search.contextClick();
        search.setValue("a"); //clear and input
        search.append("bc");
        search.dragAndDropTo(info);
        search.pressEnter();
        search.pressTab();
        search.pressEscape();


        //делаем скриншот
        try {
            BufferedImage image = search.screenshotAsImage();
            File outputfile = new File("image.png");
            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        search.download();

    }
}
