package com.github.panarik.appiumProject.model.screen.main.mobileShopping;

/**
 * Interface of screen 'Mobile shopping' for both platforms.
 * Each platform will be initialized on different classes.
 */
public interface MobileShopping {

    String SCREEN_NAME = "Mobile Shopping";

    /**
     * Verify current screen. It's on display and loaded.
     */
    void onDisplay();
}
