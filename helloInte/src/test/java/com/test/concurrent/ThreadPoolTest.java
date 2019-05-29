package com.test.concurrent;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.assertEquals;

/**
 * ClassName: ThreadPoolTest
 * Function:  TODO
 * Date:      2019-05-28 15:44
 * author     daguang
 * version    V1.0
 */
public class ThreadPoolTest {
	@Test
	public void testExecutors() {
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
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
		assertEquals(2, executor.getPoolSize());
		assertEquals(1, executor.getQueue().size());
	}

}