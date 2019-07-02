package com.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: TestAtomic
 * Function:  TODO
 * Date:      2019-07-02 16:08
 * author     daguang
 * version    V1.0
 */
@Slf4j
public class TestAtomic {
	private static AtomicInteger cur = new AtomicInteger(0);
	private static Semaphore semaphore = new Semaphore(5);
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		int number = 10;

		ExecutorService exService = Executors.newFixedThreadPool(5);
		while (cur.get() < number) {
			try {
				semaphore.acquire();
//				log.info("acquired left:{}", semaphore.availablePermits());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			exService.submit(new Runnable() {
				@Override
				public void run() {
					log.info("{} cur:{} semaphone:{}", Thread.currentThread().getName(), cur.incrementAndGet(), semaphore.availablePermits());

					semaphore.release();
//					log.info("released semaphore left:{}", semaphore.availablePermits());
				}
			});
		}
		exService.shutdown();
	}
}
