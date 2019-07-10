package com.test.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: TryBlockingQueue
 * Function:  TODO
 * Date:      2019-07-10 11:29
 * author     daguang
 * version    V1.0
 */
public class TryBlockingQueue {
	public static void main(String[] args) {
		new TryBlockingQueue().testBlockingQueue();
	}

	public void testBlockingQueue() {
		class Producer implements Runnable {
			private final BlockingQueue queue;

			Producer(BlockingQueue q) {
				queue = q;
			}

			public void run() {
				try {
					while (true) {

						boolean isok = queue.offer("test", 1, TimeUnit.MILLISECONDS);
						System.out.println(Thread.currentThread().getName() + " offered " + isok);
						if (!isok) {
							System.out.println(Thread.currentThread().getName() + " ---offer timeout ");
						}
						TimeUnit.SECONDS.sleep(1);
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
					System.out.println(Thread.currentThread().getName() + " ====timeout ");
				}
			}

		}

		class Consumer implements Runnable {
			private final BlockingQueue queue;

			Consumer(BlockingQueue q) {
				queue = q;
			}

			public void run() {
				try {
					while (true) {
						System.out.println(Thread.currentThread().getName() + " taking...");
						consume(queue.take());
						TimeUnit.MILLISECONDS.sleep(10);
					}
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}

			void consume(Object x) {
				System.out.println(Thread.currentThread().getName() + " consume: " + x);
			}
		}

		BlockingQueue queue = new LinkedBlockingQueue<>(3000);
		for (int i = 0; i < 10; i++) {
			new Thread(new Consumer(queue)).start();
		}
		new Thread(new Producer(queue)).start();

//		new Thread(new Consumer(queue)).start();
	}
}
