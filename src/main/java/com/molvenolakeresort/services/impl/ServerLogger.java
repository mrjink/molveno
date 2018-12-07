package com.molvenolakeresort.services.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerLogger {

    private static final Logger logger = Logger.getLogger("com.molvenolakeresort.services");

    public static void log(String data) {
        logger.info(data);
    }

    public static void log(Level level, String data) {
        logger.log(level, data);
    }
}
