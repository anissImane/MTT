package com.miwa.mtt;

import com.miwa.mtt.util.ApplicationProperties;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        ApplicationProperties.getInstance().load("application.properties");
        new DirectoryBrowser().run("Clock.Synch");

    }
}
