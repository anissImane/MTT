package com.miwa.mtt;


import com.miwa.mtt.util.ApplicationProperties;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class DirectoryBrowser {
    private class MetaFilenameFilter implements FilenameFilter{
        public boolean accept(File directory, String fileName) {
            return fileName.endsWith(".xml");
        }
    }


    private class DirectoryFilenameFilter implements FileFilter {
        public boolean accept(File pathname) {
            return pathname.isDirectory();
        }
    }
    private void runCurrentDirectory(File directory) {
        // Treat test files
        for (File children : directory.listFiles(new MetaFilenameFilter())) {
            new StubsRunner(children).run();
        }
        // Now going recursively in every directory
        for (File children : directory.listFiles(new DirectoryFilenameFilter())) {
            System.out.println("Dir " + children.getName());
            runCurrentDirectory(children);

        }


    }
    public void run(String specifyDir) {
        String testdir = "";
        if (specifyDir != null) {
            testdir = File.separatorChar + specifyDir.replace('.', File.separatorChar);
        }
        testdir =  ApplicationProperties.getInstance().properties.getProperty("stubs.directory") + testdir;
        File singleFile = new File(testdir + ".xml");
        File directory = new File(testdir);
        if (singleFile.exists())
            new StubsRunner(singleFile).run();
        if (directory.exists())
            runCurrentDirectory(directory);
        if (!directory.exists() && !singleFile.exists())
            throw new RuntimeException();
    }
}
