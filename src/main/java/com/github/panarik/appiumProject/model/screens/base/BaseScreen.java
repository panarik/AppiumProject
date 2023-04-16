package com.github.panarik.appiumProject.model.screens.base;

import com.github.panarik.appiumProject.controller.WebController;
import org.apache.logging.log4j.Logger;

/**
 * Abstract screen class.
 */
public abstract class BaseScreen {

    protected Logger log = WebController.log;



    /**
     * Necessary method for checking about current screen. It's on display now or not.
     */
    public abstract void onDisplay();
}
