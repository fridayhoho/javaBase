package com.test.concurrent;

import java.lang.reflect.Array;
import java.util.List;

/**
 * ClassName: NonVisiblitiy
 * Function:  TODO
 * Date:      2019-06-06 14:13
 * author     daguang
 * version    V1.0
 */
public class NonVisiblitiy {
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread {
		public void run() {
			while (!ready) {
				System.out.println("waiting");
				Thread.yield();
			}
			System.out.println(number);
		}
	}

	public static void main(String[] args) throws InterruptedException {
//		new ReaderThread().start();
//		Thread.sleep(1);
//		number = 42;
//		ready = true;
		System.out.println(List.class.getCanonicalName());
	}

}
