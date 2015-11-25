package com.miwa.mtt.sender;

import com.miwa.mtt.pojo.Stub;
import com.miwa.mtt.sender.impl.AsynchSender;
import com.miwa.mtt.sender.impl.FileSender;
import com.miwa.mtt.sender.impl.SynchSender;

public class SenderFactory {
    public Sender create(Stub stub) {
        switch (stub.getType().getValue()) {
            case "asynch":
                return new AsynchSender(stub);
            case "synch":
                return new SynchSender(stub);
            case "file":
                return new FileSender(stub);
        }
        throw new RuntimeException();
    }
}
