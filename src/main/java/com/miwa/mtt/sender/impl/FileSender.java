package com.miwa.mtt.sender.impl;

import com.miwa.mtt.pojo.Stub;
import com.miwa.mtt.sender.Sender;

import java.io.*;
import java.net.SocketException;

import com.miwa.mtt.util.ApplicationProperties;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FileSender implements Sender {

    private Stub stub;

    public FileSender(Stub stub) {
        this.stub = stub;
    }


    public void Send() {
        System.out.println("Sending File");

        String server = ApplicationProperties.getInstance().getProperty("file.url");
        int port = Integer.valueOf(ApplicationProperties.getInstance().getProperty("file.port"));
        String user = ApplicationProperties.getInstance().getProperty("file.username");
        String pass = ApplicationProperties.getInstance().getProperty("file.password");

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            String localPath = ApplicationProperties.getInstance().getProperty("file.directory") + File.separatorChar + stub.getFilePath();

            File localFile = new File(localPath);

            String remoteFile = stub.getFilePath();
            InputStream inputStream = new FileInputStream(localFile);

            System.out.println("Start uploading: " + localFile.getName());
            boolean done = ftpClient.storeFile(remoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("Finished uploading: " + localFile.getName());
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Couldn't find file " + ex.getMessage());
            ex.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
