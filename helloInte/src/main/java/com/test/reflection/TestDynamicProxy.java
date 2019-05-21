package com.test.reflection;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDynamicProxy {
    public static void main(String[] args) {
        List mapProxyInstance = (List) Proxy.newProxyInstance(
                TestDynamicProxy.class.getClassLoader(), new Class[]{List.class},
                new TimingDynamicInvocationHandler(new ArrayList<>()));

        mapProxyInstance.add("test");

//        CharSequence csProxyInstance = (CharSequence) Proxy.newProxyInstance(
//                TestDynamicProxy.class.getClassLoader(),
//                new Class[]{CharSequence.class},
//                new TimingDynamicInvocationHandler("Hello World"));
//
//        csProxyInstance.length();

    }
}
