package com.test.concurrent;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: TestThreadPool
 * Function:  TODO
 * Date:      2019-07-02 15:03
 * author     daguang
 * version    V1.0
 */
public class TestThreadPool {
	/**
	 * 模拟mysql 里有100w条记录
	 */
	private static AtomicInteger dataCountsInMysql = new AtomicInteger(100_0000);
	/**
	 * IO 密集型任务：由于线程并不是一直在运行，所以可以尽可能的多配置线程，比如 CPU 个数 * 2
	 * 导数据属于IO密集型
	 * <p>
	 * CPU 密集型任务（大量复杂的运算）应当分配较少的线程，比如 CPU 个数相当的大小
	 */
	private static final int POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;

	private static ThreadPoolExecutor threadPoolExecutor;

	private static boolean isRunning = false;
	private static Random random = new Random();
	/**
	 * 定时器  Timer
	 */
	private static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
	public static void main(String[] args) {
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" cur:"+ System.currentTimeMillis());
			}
		}, 0,  1, TimeUnit.SECONDS);

//		threadPoolExecutor =
//				(ThreadPoolExecutor) Executors.newFixedThreadPool(POOL_SIZE);
//		isRunning = true;
//		addOneWorker();
//		addOneWorker();
//		addOneWorker();
//
//		System.out.println(threadPoolExecutor.getQueue().size());
//
//		try {
//			Thread.sleep(4000);
//			isRunning = false;
//			threadPoolExecutor.shutdown();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	private static void addOneWorker(){
		/**
		 * 匿名内部类
		 */
		threadPoolExecutor.submit(new Runnable() {
			@Override
			public void run() {
				Thread.currentThread().setName(" thread"+ random.nextInt(20));
				while(isRunning) {
					int dataLeft = dataCountsInMysql.decrementAndGet();
					System.out.println(Thread.currentThread().getName() + " dataLeft: " + dataLeft);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
