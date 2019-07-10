package com.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: TestLock
 * Function:  TODO
 * Date:      2019-07-02 20:12
 * author     daguang
 * version    V1.0
 */
public class TestLock {
	private static Lock rLock = new ReentrantLock(true);
	private static final Condition holdingMinutes = rLock.newCondition();
	private static AtomicInteger minute = new AtomicInteger();

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		ExecutorService exService = Executors.newFixedThreadPool(5);
		while (true) {
			rLock.lock();
			exService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName() + "hold");
						TimeUnit.SECONDS.sleep(1);

					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						rLock.unlock();
					}
				}
			});
		}
	}
}
