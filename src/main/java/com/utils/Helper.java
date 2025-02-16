package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

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
            ex.printStackTrace();
        }
        return properties.getProperty(key);
    }

    static String getEnv() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(path + "/src/test/resources/Test.properties"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties.getProperty("env");
    }

    static String getEndpoint() {
        if (getEnv().equalsIgnoreCase("qa"))
            return getProperty("rest.qa.endpoint");
        return getProperty("rest.dev.endpoint");
    }
}
