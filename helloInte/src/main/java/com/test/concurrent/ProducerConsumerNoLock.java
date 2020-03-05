package com.test.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ProducerConsumerNoLock
 * Function:  TODO
 * Date:      2020-03-05 11:01
 * author     daguang
 * version    V1.0
 */
public class ProducerConsumerNoLock {
	/**
	 * 有多少钱
	 */
	private static int countsRMB = 0;

	public static void main(String[] args) {
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
		new Thread(new Consumer()).start();
	}

	private static class Producer implements Runnable {

		@Override
		public void run() {
			while (true) {
				countsRMB ++;
				System.out.println("producer curRMB:"+ countsRMB);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class Consumer implements Runnable {

		@Override
		public void run() {
			while (true) {
				if (countsRMB > 0) {
					countsRMB--;
				}
				System.out.println("consumer curRMB:"+ countsRMB);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
