package com.miwa.mtt.sender.impl;

import com.miwa.mtt.pojo.Stub;
import com.miwa.mtt.sender.Sender;
import com.miwa.mtt.util.ApplicationProperties;
import com.miwa.mtt.util.SelectValue;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class AsynchSender implements Sender {

    private Stub stub;

    public AsynchSender(Stub stub) {
        this.stub = stub;
    }

    public void Send() {
        System.out.println("    [ASYNCH] Sending :" + stub.getMessage().getValue());

        String QUEUE_NAME = SelectValue.getDefault("asynch.queue.name", stub.getType().getQueueName());
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ApplicationProperties.getInstance().getProperty("asynch.url"));
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, stub.getMessage().getValue().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            try {
                if (channel != null)
                    channel.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();

            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

    }
}
