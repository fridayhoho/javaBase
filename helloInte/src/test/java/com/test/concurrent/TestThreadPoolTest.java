package com.test.concurrent;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

/**
 * ClassName: TestThreadPoolTest
 * Function:  TODO
 * Date:      2019-07-02 15:04
 * author     daguang
 * version    V1.0
 */
public class TestThreadPoolTest {



	@Test
	public void testPool() {
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
		for (int i = 0; i < 1000000; i++) {
			executor.submit(() -> {
				Thread.sleep(1000);
				return null;
			});
		}


		assertEquals(2, executor.getPoolSize());
		assertEquals(1000000, executor.getQueue().size());
	}
}