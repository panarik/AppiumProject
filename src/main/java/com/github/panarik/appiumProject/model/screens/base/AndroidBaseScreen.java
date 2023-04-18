package com.github.panarik.appiumProject.model.screens.base;

import com.github.panarik.appiumProject.controller.AndroidController;

public abstract class AndroidBaseScreen {

    private final AndroidController controller;

    protected AndroidBaseScreen() {
        this.controller = new AndroidController();
    }

}
