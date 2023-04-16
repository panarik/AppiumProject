package com.github.panarik.appiumProject.model.screens.base;

import com.github.panarik.appiumProject.controller.WebController;
import com.github.panarik.appiumProject.tools.Log;


public abstract class BaseScreen {


    private final WebController controller;
    protected Log log = new Log();

    protected BaseScreen() {
        this.controller = new WebController();
    }

    /**
     * Necessary method for checking about current screen. It's on display now or not.
     */
    public abstract void onDisplay();
}
