package com.test.lambda;

import java.io.*;

public class ConciseBr {
    public static String readFile(BufferedBr bufferedBr) {
        File file = new File("/Users/daguang/Documents/vpngateMirror.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            return bufferedBr.process(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String online = readFile((BufferedReader br) -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        System.out.println("oneline:"+online);
        String twoLine = readFile((BufferedReader br) -> {
            try {
                return br.readLine() +"\n"+ br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        System.out.println("twoLine:"+twoLine);
    }
}

@FunctionalInterface
interface BufferedBr {
    String process(BufferedReader br);
}