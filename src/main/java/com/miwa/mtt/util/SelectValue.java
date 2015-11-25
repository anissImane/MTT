package com.miwa.mtt.util;


public class SelectValue {
    public static String getDefault(String property, String value) {
        if (value == null || value.equals(""))
            return ApplicationProperties.getInstance().getProperty(property);
        else
            return value;
    }
}
