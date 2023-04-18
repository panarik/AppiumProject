package com.github.panarik.appiumProject.tools;

import org.apache.logging.log4j.LogManager;

public class Log {

    public void info(String message) {
        LogManager.getLogger().info(message);
    }

}
