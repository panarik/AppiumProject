package com.github.panarik.appiumProject.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private final Logger log = LogManager.getLogger();

    public void info(String message) {
        LogManager.getLogger().info(message);
    }

}
