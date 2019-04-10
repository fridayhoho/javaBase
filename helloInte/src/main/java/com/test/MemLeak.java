package com.test;

import java.util.HashMap;
import java.util.Map;

public class MemLeak {

    public final String key;

    

    public MemLeak(String key) {

        this.key =key;

    }

    

    public static void main(String args[]) {

        try {

            Map map = new HashMap();

            

            for(;;) {
//                Thread.sleep(1000);
                MemLeak memLeak = new MemLeak("key");
//                System.out.println(memLeak.hashCode());
                map.put(memLeak, "value"+System.currentTimeMillis());

            }

        } catch(Exception e) {

            e.printStackTrace();

        }

    }

}