package com.miwa.mtt.sender.impl;

import com.miwa.mtt.pojo.Stub;
import com.miwa.mtt.sender.Sender;

public class AsynchSender implements Sender {

    private Stub stub;

    public AsynchSender(Stub stub) {
        this.stub = stub;
    }

    public void Send() {
        System.out.println("Sending Asynch");

    }
}
