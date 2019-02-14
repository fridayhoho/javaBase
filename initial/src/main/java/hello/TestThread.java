package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestThread {
	static Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestThread tt = new TestThread();
		Consumer consumer = tt.new Consumer();
		Producer producer = tt.new Producer();

		new Thread(consumer).start();
		new Thread(producer).start();
	}

	private static List<String> tasks = new ArrayList<String>();

	/**
	 * 1 v 1
	 * 
	 * @author daguang
	 *
	 */
	public class Consumer implements Runnable {

		@Override
		public void run() {
			logger.info("Consumer start....");
			while (true) {
				logger.info("consumer checking...");
				synchronized (tasks) {
					if (tasks.isEmpty()) {
						try {
							logger.info("consumer wait...");
							tasks.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						logger.info("consume #######get:" + tasks.get(0));
						tasks.clear();
						tasks.notify();
					}
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	class Producer implements Runnable {

		@Override
		public void run() {
			logger.info("Producer start....");
			while (true) {
				synchronized (tasks) {
					if (tasks.isEmpty()) {
						Random rand = new Random();
						String bt = Integer.toString(rand.nextInt(20));
						logger.info("producer =====push notify:" + bt);
						tasks.add(bt);
						tasks.notify();
					} else {
						try {
							logger.info("producer wait");
							tasks.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
