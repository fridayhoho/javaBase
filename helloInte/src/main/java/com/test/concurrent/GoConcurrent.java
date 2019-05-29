package com.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class GoConcurrent {
    static AtomicInteger counter= new AtomicInteger();
    private static Queue<String> sqlQueue = new ConcurrentLinkedQueue<String>();
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.execute(()->{
            while (true) {
                if (System.currentTimeMillis() % 2 == 0 && System.currentTimeMillis() %3 ==0) {
                    sqlQueue.add("test");
                    log.info("counterInc:{}", counter.incrementAndGet());
                } else {
                    if (!sqlQueue.isEmpty()){
                        sqlQueue.poll();
                        if (counter.get() > 0) {
                            log.info("countDec:{}", counter.decrementAndGet());
                        }
                    }

                }
//                try {
//                    TimeUnit.MILLISECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }
}
