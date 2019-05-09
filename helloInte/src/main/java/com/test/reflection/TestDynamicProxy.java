package com.test.reflection;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class TestDynamicProxy {
    public static void main(String[] args) {
        Map mapProxyInstance = (Map) Proxy.newProxyInstance(
                TestDynamicProxy.class.getClassLoader(), new Class[]{Map.class},
                new TimingDynamicInvocationHandler(new HashMap<>()));

        mapProxyInstance.put("hello", "world");

        CharSequence csProxyInstance = (CharSequence) Proxy.newProxyInstance(
                TestDynamicProxy.class.getClassLoader(),
                new Class[]{CharSequence.class},
                new TimingDynamicInvocationHandler("Hello World"));

        csProxyInstance.length();

    }
}
