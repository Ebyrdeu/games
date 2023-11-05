package com.example.games.lib.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static final Logger LOGGER = Logger.getLogger("");

    static {
        try {
            var fileHandler = new FileHandler("src/main/resources/logs/logs.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.severe("Failed to create log file");
            throw new RuntimeException(e);
        }
    }

    private Log() {

    }

    public static void message(String message) {
        logMessage(message);
    }


    private static void logMessage(String message) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length > 3) {
            var callingClassName = stackTraceElements[3].getClassName();
            LOGGER.logp(Level.INFO, callingClassName, "", message);
        } else {
            LOGGER.info(message);
        }
    }

}
