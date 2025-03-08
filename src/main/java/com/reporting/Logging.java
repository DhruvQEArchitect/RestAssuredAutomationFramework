package com.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {

    static final Logger logger = LogManager.getLogger(Logging.class.getName());

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logInfo(String message, Object object) {
        logger.info(message, object);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    public static void logWarning(String message) {
        logger.warn(message);
    }

}
