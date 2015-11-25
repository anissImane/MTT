package com.miwa.mtt.sender.impl;

import com.miwa.mtt.pojo.Stub;
import com.miwa.mtt.sender.Sender;

public class FileSender implements Sender {

    private Stub stub;

    public FileSender(Stub stub) {
        this.stub = stub;
    }


    public void Send() {
        System.out.println("Sending File");
    }
}
