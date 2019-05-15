package com.test.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestBuildProxy implements InvocationHandler {

    private Object obj;

    public TestBuildProxy(Object obj) {
        this.obj = obj;
    }


    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new TestBuildProxy(obj));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        Object result = null;
        System.out.println("---before method " + method.getName());
        try {
            result = method.invoke(obj, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            System.out.println("---after method:"+method.getName());
        }

        return result;
    }

    public static void main(String[] args) {
        BuildBehaviour buildBehaviour = (BuildBehaviour) TestBuildProxy.newInstance(new JavaBuilder());
        buildBehaviour.doBuild();

    }
}
