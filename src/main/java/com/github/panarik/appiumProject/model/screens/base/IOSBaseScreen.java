package com.github.panarik.appiumProject.model.screens.base;

import com.github.panarik.appiumProject.controller.IOSController;

public abstract class IOSBaseScreen {

    private final IOSController controller;

    protected IOSBaseScreen() {
        controller = new IOSController();
    }

}
