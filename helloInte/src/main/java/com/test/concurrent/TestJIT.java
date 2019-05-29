package com.test.concurrent;

public class TestJIT {
	public static void main(String[] args) throws Exception {
		C c = new C();
		c.start();
		Thread.sleep(1 * 1000);
		c.stopNow();
		c.join();
	}

	private static class C extends Thread {
		private boolean running = true;
		private int i;

		@Override
		public void run() {
			while (running) {
				i++;
				System.out.println(i);
			}
//			if (System.currentTimeMillis() == 0) {
				System.out.println(i);
//			}
		}

		public void stopNow() {
			running = false;
		}
	}
}