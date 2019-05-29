package com.test.concurrent;

/**
 * ClassName: ReOrdering
 * Function:  TODO
 * Date:      2019-05-28 16:06
 * author     daguang
 * version    V1.0
 */
public class ReOrdering {
	static int x = 0, y = 0;
	static int a = 0, b = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(new Runnable() {
			public void run() {
				a = 1;
				x = b;
			}
		});
		Thread other = new Thread(new Runnable() {
			public void run() {
				b = 1;
				y = a;
			}
		});
		one.start();
		other.start();
		one.join();
		other.join();
//		a 1 b 1 x 0 y 1
		System.out.println("a:"+a +" b:"+ b);
		System.out.println("( " + x + "," + y + ")");
	}
}
