package com.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * ClassName: TestSemaphone
 * Function:  TODO
 * Date:      2019-06-06 10:54
 * author     daguang
 * version    V1.0
 */
@Slf4j
public class TestSemaphone {
	public static void main(String[] args) {
		testAcquire();
	}

	public static void testAcquire(){
		Semaphore semaphore = new Semaphore(1);
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info("release semaphone {}", semaphore.availablePermits());
				semaphore.release();

				semaphore.release();
				log.info("release semaphone {}", semaphore.availablePermits());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean acquired = semaphore.tryAcquire();
				log.info("acquired:{}", acquired);
			}
		}).start();


	}
}
