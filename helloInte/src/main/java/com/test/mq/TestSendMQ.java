package com.test.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class TestSendMQ {
    private final static String QUEUE_NAME = "Hello";

    public static void main(String[] args) {
        testSend();
    }

    public static void testSend() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672); //默认端口号
        factory.setUsername("guest");//默认用户名
        factory.setPassword("guest");//默认密码
        try {
            final Connection conn = factory.newConnection();
            ExecutorService executors = Executors.newFixedThreadPool(1);
            for (int i = 0; i < 1; i++) {

                executors.execute(() -> {
                    String tname = String.valueOf(Math.random() * 10 % 10);
                    Thread.currentThread().setName(tname);


                    try (Channel channel = conn.createChannel()) {
                        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//                            String message = "S00000000008";
//                        PSDRF00388
                        String message = "030{6666666666,01,{T01:21:00,T02:20:00,T03:20:00,T11:21:00,E01:0:00,E02:0:00,E03:0:00,E11:451:02,}}";
//                        if (Math.round(Math.random()) % 2 == 0) {
//                            message = "S00000000008";
//                        }
                        message = "030{ANXZH00001,02,{T01:27:00,T02:27:00,T03:28:00,T11:0:04,E01:0.0:00,E02:4.1:00,E03:0.0:00,E11:1100:02,}}";
//                        message = "030{ANXZH00001,02,{T01:27:00,T02:250:02,T03:28:00,T11:0:04,E01:0.0:00,E02:4.1:00,E03:0.0:00,E11:1100:02,}}";
                            message = "S01000000366";
                        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                        System.out.println("send2MQ:" + message);

                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    executors.shutdown();
                    System.exit(0);
                });
            }
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
