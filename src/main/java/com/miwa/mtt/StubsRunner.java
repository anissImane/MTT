package com.miwa.mtt;

import com.miwa.mtt.pojo.Stub;
import com.miwa.mtt.sender.SenderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class StubsRunner {
    private File file;

    public StubsRunner(File file) {
        this.file = file;
    }

    public void run() {

        System.out.println("RUNNING file: " + file.getName());
        try {
            JAXBContext context = JAXBContext.newInstance(Stub.class);
            Unmarshaller un = context.createUnmarshaller();
            Stub stub = (Stub) un.unmarshal(file);

            // Sending stub
            new SenderFactory().create(stub).Send();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
