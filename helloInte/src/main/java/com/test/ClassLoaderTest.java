package com.test;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) {


        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".")+1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte[] bt = new byte[is.available()];
                    is.read(bt);
                    return defineClass(name, bt, 0, bt.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return null;
            }
        };
        try {
            Object myobj = myLoader.loadClass("com.test.ClassLoaderTest").newInstance();
            System.out.println(myobj.getClass());

            System.out.println(myobj instanceof  ClassLoaderTest);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
