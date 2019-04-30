package com.test.billion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuperAI {
    public static void main(String[] args) {
        String inputS = "";
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        System.out.println("你好，mose为您服务");
        try {
            inputS = bufferedReader.readLine();//获得数据
            while (inputS != null) {


                inputS = inputS.replace("吗", "");
                inputS = inputS.replace("么", "");
                inputS = inputS.replace("？", "!");
                inputS = inputS.replace("?", "!");
                inputS = inputS.replace("?", "!");
                System.out.println(inputS);
                inputS = bufferedReader.readLine();//获得数据
            }
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println(e.toString());
        }

    }
}
