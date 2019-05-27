package com.test.tcp;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * ClassName: TheSocketServer
 * Function:  TODO
 * Date:      2019-05-23 20:21
 * author     daguang
 * version    V1.0
 */
@Slf4j
public class TheSocketServer {

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer(){
        String ip = "192.168.1.89";
        int port = 9999;
        try {
            ServerSocket serverSocket = new ServerSocket();

            serverSocket.bind(new InetSocketAddress(ip, port));
            log.info("bind:{}, port:{}",ip,  port);
            System.out.println("ip: "+ip+" port:"+port);
            Socket socket = serverSocket.accept();
            log.info("client connected:{}", socket.getInetAddress().getHostAddress());
            socket.close();
            serverSocket.close();
            log.info("server closed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
