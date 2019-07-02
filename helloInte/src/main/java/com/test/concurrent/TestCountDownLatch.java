package com.test.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: TestCountDownLatch
 * Function:  TODO
 * Date:      2019-07-02 15:43
 * author     daguang
 * version    V1.0
 */
public class TestCountDownLatch {
	public static void main(String[] args) {
		testCdown();
	}

	public static void testCdown(){
		CountDownLatch countDownLatch = new CountDownLatch(1);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("wait");
					countDownLatch.await();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					countDownLatch.countDown();
					System.out.println("down"+countDownLatch.getCount());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
