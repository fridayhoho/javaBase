package com.test.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * ClassName: ThreadPoolExceptionCatch
 * Function:  TODO
 * Date:      2019-07-23 14:41
 * author     daguang
 * version    V1.0
 */
@Slf4j
public class ThreadPoolExceptionCatch {
	public static void main(String[] args) {
		testPool();
	}

	public static void testPool() {
//		ThreadFactory factory = new ThreadFactory() {
//			@Override
//			public Thread newThread(Runnable r) {
//				Thread th = new Thread(r);
//				th.setUncaughtExceptionHandler(new MyUEHLogger());
//				return th;
//			}
//		};

		ExecutorService executorService =
				new ThreadPoolExecutor(1, 1, 2,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>());
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				int cnt = 0;
				try {

					Thread.currentThread().setName("threadEx");
					while (!Thread.currentThread().isInterrupted()) {
						cnt++;
						log.info("running... {}", cnt);

						TimeUnit.SECONDS.sleep(1);
						if (cnt >= 2) {
							int age = 9 / 0;
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					log.error("inteerrupt===");
//					Thread.currentThread().interrupt();
//					executorService.shutdown();
				}
			}
		});
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		executorService.execute(new Runnable() {
			@Override
			public void run() {

				log.info("here? {}", Thread.currentThread().getName());

			}
		});
//		try {
//			Object obj = future.get();
//
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			future.cancel(true);
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
		log.info("done----");
	}

	static class MyUEHLogger implements Thread.UncaughtExceptionHandler {

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			log.error("uncaughtEx: {} {}", t.getName(), e.getMessage());
		}
	}
}
