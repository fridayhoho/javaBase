package com.test.lambda;

import java.util.ArrayList;
import java.util.List;

public class TestFunction {

    public static void main(String[] args) {

        Integer aInt = 99;
        Integer bInt = 100;
        System.out.println(aInt);
        System.out.println(bInt);

        swapValue(aInt, bInt);

        System.out.println(aInt);
        System.out.println(bInt);
    }
    static void testPrint(MyFirstFunctionInterface myFirstFunctionInterface) {
        myFirstFunctionInterface.firstWork();
    }

    static void swapValue(Integer aInt, Integer bInt){
        Integer tmp = new Integer(aInt);
        aInt = bInt;
        bInt = tmp;
    }
}

@FunctionalInterface
interface MyFirstFunctionInterface {
    public void firstWork();


}

class MyTest implements MyFirstFunctionInterface {

    @Override
    public void firstWork() {
        System.out.println("hahaHo");
    }
}