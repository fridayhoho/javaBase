package hello;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestExcutorService {
	static Logger logger = LogManager.getLogger();

	// ...
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GcLogUtil.startLoggingGc();
		TestExcutorService ts = new TestExcutorService();

		ts.start();
		while(true) {
			String ss = new String("sfdlkjsdklfs");
			ss = ss + "hello";
		}
		
	}

	ExecutorService executor = Executors.newFixedThreadPool(10);

//	public void doExcute() {
//		start();
//	}

	public void start() {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
			// ...
			logger.info("All previous tasks are completed");
		});

		Thread t1 = new Thread(new Task(cyclicBarrier), "T1");
		Thread t2 = new Thread(new Task(cyclicBarrier), "T2");
		Thread t3 = new Thread(new Task(cyclicBarrier), "T3");

		if (!cyclicBarrier.isBroken()) {
			t1.start();
			t2.start();
			t3.start();
		}
	}

	public class Task implements Runnable {

		private CyclicBarrier barrier;

		public Task(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

		@Override
		public void run() {
			try {
				String ss = new String("test....");
				logger.info(Thread.currentThread().getName() + " is waiting");
				barrier.await();
				logger.info(Thread.currentThread().getName() + " is released");
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}

	}

}
