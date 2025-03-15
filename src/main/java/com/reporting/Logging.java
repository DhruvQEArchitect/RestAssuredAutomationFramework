package com.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class initializes logger for logging purposes and could be utilized by simply calling with class name
 */
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

    public static void logError(String message, Object object) {
        logger.error(message, object);
    }

    public static void logWarning(String message) {
        logger.warn(message);
    }

    public static void logWarning(String message, Object object) {
        logger.warn(message, object);
    }

}
