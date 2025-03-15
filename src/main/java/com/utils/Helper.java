package com.utils;

import com.reporting.Logging;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This helper class provide ways to get environment, load any properties or environment needed
 * for test execution and all the properties should be provided in the Test.properties file
 */
public class Helper {

    static String path = System.getProperty("user.dir");
    static Properties properties;

    private static Helper instance = null;

    public static Helper getInstance() {
        if (instance == null)
            instance = new Helper();
        return instance;
    }

    public static String getProperty(String key) {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path + "/src/test/resources/Test.properties"));
        } catch (Exception ex) {
            Logging.logInfo("Exception caught: ", ex.getMessage());
        }
        return properties.getProperty(key);
    }

    static String getEnv() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path + "/src/test/resources/Test.properties"));
        } catch (Exception ex) {
            Logging.logInfo("Exception caught: ", ex.getMessage());
        }
        return properties.getProperty("env");
    }

    static String getEndpoint() {
        if (getEnv().equalsIgnoreCase("qa"))
            return getProperty("rest.qa.endpoint");
        return getProperty("rest.dev.endpoint");
    }
}
