package com.github.panarik.appiumProject.controller;

import com.github.panarik.appiumProject.model.base.MobileItem;
import org.testng.Assert;

public class BaseController {

    protected void failAfterWaiting(MobileItem mobileitem) {
        Assert.fail("Элемент " + mobileitem.getName() + " не найден.");
    }

}
