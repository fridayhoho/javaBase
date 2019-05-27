package com.test.tcp;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClassName: OneClient
 * Function:  test  CLOSE_WAIT
 * Date:      2019-05-23 20:25
 * author     daguang
 * version    V1.0
 */
@Slf4j
public class OneClient {
    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            Socket socket = new Socket(host, port);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入...");
            String str = scanner.nextLine();
            System.out.println("输入了:" + str);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
