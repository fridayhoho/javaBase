package com.test.collection;

import java.util.HashMap;

public class TestHashMap {
    HashMap hashMap = new HashMap();

    public static void main(String[] args) {
        int hash = h("hello", 2 );
        System.out.println(hash);
    }

    static int h(String x, int M) {
        char ch[];
        ch = x.toCharArray();
        int xlength = x.length();

        int i, sum;
        for (sum = 0, i = 0; i < x.length(); i++)
            sum += ch[i];
        return sum % M;
    }
}
