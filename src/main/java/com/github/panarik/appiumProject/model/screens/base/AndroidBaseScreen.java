package com.github.panarik.appiumProject.model.screens.base;

import com.github.panarik.appiumProject.controller.AndroidController;

public class AndroidBaseScreen {

    protected AndroidController controller;

    protected AndroidBaseScreen() {
        this.controller = new AndroidController();
    }

}
