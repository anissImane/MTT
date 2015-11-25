package com.miwa.mtt.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {
    public Properties properties = new Properties();
    private static ApplicationProperties instance = new ApplicationProperties();
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static ApplicationProperties getInstance() {
        return instance;
    }
    public void load (String filename) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filename);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
