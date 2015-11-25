package com.miwa.mtt;

import com.miwa.mtt.util.ApplicationProperties;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String stubPath = "Clock.SSynch";
        ApplicationProperties.getInstance().load("application.properties");
        try {
            new DirectoryBrowser().run(stubPath);
        } catch (FileNotFoundException e) {
            System.err.println("Couldn't find stub's files matching: " + stubPath);
        }
    }
}
