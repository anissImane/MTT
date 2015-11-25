package com.miwa.mtt.pojo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "stub")
@XmlType(propOrder = {"name", "type", "message", "filePath"})
public class Stub {
    private String name;
    private StubType type;
    private MessageType message;
    private String filePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StubType getType() {
        return type;
    }

    public void setType(StubType type) {
        this.type = type;
    }

    public MessageType getMessage() {
        return message;
    }

    public void setMessage(MessageType message) {
        this.message = message;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
