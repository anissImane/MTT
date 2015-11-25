package com.miwa.mtt.sender;

import com.miwa.mtt.pojo.Stub;
import com.miwa.mtt.sender.impl.AsynchSender;
import com.miwa.mtt.sender.impl.FileSender;
import com.miwa.mtt.sender.impl.SynchSender;

public class SenderFactory {
    public Sender create(Stub stub) {
        System.out.println(stub.getType().getValue());
        if (stub.getType().getValue().equals("asynch")) {
            return new AsynchSender(stub);
        }
        else if (stub.getType().getValue().equals("synch")) {
            return new SynchSender(stub);
        }
        else if (stub.getType().getValue().equals("file")) {
            return new FileSender(stub);
        }
        throw new RuntimeException();
    }
}
