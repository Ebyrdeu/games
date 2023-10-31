package com.example.games.lib.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {
    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

    private Log() {
    }

    static {
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logs/server.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Failed to create log file", e);
        }
    }

    public static void info(String message) {
        LOGGER.info(message);
    }

    public static void error() {
        LOGGER.severe("Error");
    }

    public static void error(String message) {
        LOGGER.severe(message);
    }

}
