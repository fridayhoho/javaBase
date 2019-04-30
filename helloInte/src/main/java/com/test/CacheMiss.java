package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;


public class CacheMiss {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        http://www.javapractices.com/topic/TopicAction.do?Id=250
//        https://stackoverflow.com/questions/29098117/shutdown-or-not-shutdown-in-executorservice-java8
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        });


        final List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            intList.add(i);
        }
        System.out.println("Main Thread : " + Thread.currentThread().getName());
        doSomeRandomOperationInList(intList);
        doSomeRandomOperationInList(intList);
        doSomeRandomOperationInList(intList);
        doSomeRandomOperationInList(intList);
        doSomeRandomOperationInList(intList);
        runWithExecutor(intList);
//        runAsync(intList, 1);
//        runAsync(intList, 2);
//        runAsync(intList, 3);
//        runAsync(intList, 4);
//        runAsync(intList, 5);
//        runWithThread(intList, 1);
//        runWithThread(intList, 2);
//        runWithThread(intList, 3);
//        runWithThread(intList, 4);
//        runWithThread(intList, 5);
        TimeUnit.SECONDS.sleep(1);
    }

    private static void runAsync(List<Integer> intList, int t) {
        CompletableFuture.runAsync(() -> someTaskNormal("CompletableFuture.runAsync", t, intList));
    }

    private static void doSomeRandomOperationInList(List<Integer> intList) {
//        long startTime = System.currentTimeMillis();
//        List<Integer> integerList = intList.stream().map(i -> i * 2).collect(Collectors.toList());
//        long endTime = System.currentTimeMillis();
//        System.out.println(
//                "串行处理 : " + Thread.currentThread().getName() + " : Time Taken in (ms) : " + (endTime - startTime));
        someTaskNormal("serial", 1, intList);
    }

    private static void runWithThread(List<Integer> intList, int t){
        new Thread(() -> someTaskNormal("newThreadEach", t, intList)).start();
    }

    private static void someTaskNormal(String stKind, int t, List<Integer> intList) {

//        System.out.println(stKind +"" + t + " : " + Thread.currentThread().getName());
        long s = System.currentTimeMillis();
        List<Integer> l = new ArrayList<>();
        for (Integer i : intList) {
            Integer integer = i * 2;
            l.add(integer);
        }
        long e = System.currentTimeMillis();
        System.out.println(stKind +" " + t + "last : " + (e - s));
    }

    private  static void runWithExecutor(List<Integer> intList){
        System.out.println("=====runWithExecutor=====");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    someTaskNormal("ExecutorService", finalI, intList);
                }
            });
        }
    }
}