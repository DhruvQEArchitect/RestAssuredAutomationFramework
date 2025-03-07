package com.reporting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerMech {

    private static final Logger logger = LogManager.getLogger(LoggerMech.class);

    public static void main(String[] args) {
        logger.debug("welcome to java");
    }

}
