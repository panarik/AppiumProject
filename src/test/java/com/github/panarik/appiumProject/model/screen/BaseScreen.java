package com.github.panarik.appiumProject.model.screen;

import com.github.panarik.appiumProject.controller.Controller;

/**
 * Abstract screen class.
 */
public abstract class BaseScreen extends Controller {

    /**
     * Necessary method for checking about current screen. It's on display now or not.
     */
    public abstract void onDisplay();
}
