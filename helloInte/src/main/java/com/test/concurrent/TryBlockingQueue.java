package com.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * ClassName: TryBlockingQueue
 * Function:  TODO
 * Date:      2019-07-10 11:29
 * author     daguang
 * version    V1.0
 */
@Slf4j
public class TryBlockingQueue {
	public static void main(String[] args) {
//		new TryBlockingQueue().testBoundSize();

		BigDecimal bigDecimal = new BigDecimal("3456.3");
		bigDecimal = bigDecimal.setScale(3, RoundingMode.FLOOR);

		System.out.println(bigDecimal.floatValue());
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

	private void testBoundSize() {
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 2, 0,
				TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (poolExecutor.getQueue().size() > 2){
					return;
				}
				poolExecutor.execute(new Runnable() {
					@Override
					public void run() {
						log.info(Thread.currentThread().getName());
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
				log.info("task:{} active:{} completed:{}", poolExecutor.getTaskCount(), poolExecutor.getActiveCount(), poolExecutor.getCompletedTaskCount());

			}
		}, 0, 100);
	}
}
