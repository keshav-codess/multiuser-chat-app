package com.codess.chatapp.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ConfigReader {

    private static final ResourceBundle rb = ResourceBundle.getBundle("config");

    private ConfigReader() {} 

    public static String getValue(String key) {
        try {
            return rb.getString(key);
        } catch (MissingResourceException e) {
            System.err.println(" Missing key in config file: " + key);
            return null; 
        }
    }
}
