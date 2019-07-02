package com.test.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: TestThreadPool
 * Function:  TODO
 * Date:      2019-07-02 15:03
 * author     daguang
 * version    V1.0
 */
public class TestThreadPool {
	public static void main(String[] args) {

	}

	public  static void testPool(){
		ThreadPoolExecutor executor =
				(ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		executor.submit(() -> {
			Thread.sleep(1000);
			return null;
		});
		executor.submit(() -> {
			Thread.sleep(1000);
			return null;
		});
		executor.submit(() -> {
			Thread.sleep(1000);
			return null;
		});


	}
}
