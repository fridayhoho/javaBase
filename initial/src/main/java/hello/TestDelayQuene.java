package hello;

import static org.junit.Assert.assertEquals;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.google.common.primitives.Ints;

public class TestDelayQuene {
	static Logger logger = LogManager.getLogger();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new TestDelayQuene().givenDelayQueue_whenProduceElement_thenShouldConsumeAfterGivenDelay();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Test
	public void givenDelayQueue_whenProduceElement_thenShouldConsumeAfterGivenDelay() throws InterruptedException {
		// given
		ExecutorService executor = Executors.newFixedThreadPool(2);

		BlockingQueue<DelayObject> queue = new DelayQueue<>();
		int numberOfElementsToProduce = 1;
		int delayOfEachProducedMessageMilliseconds = 4_000;
		DelayQueueConsumer consumer = new DelayQueueConsumer(queue, numberOfElementsToProduce);
		DelayQueueProducer producer = new DelayQueueProducer(queue, numberOfElementsToProduce,
				delayOfEachProducedMessageMilliseconds);

		// when
		executor.submit(producer);
		executor.submit(consumer);

		// then
		executor.awaitTermination(5, TimeUnit.SECONDS);
		executor.shutdown();

		assertEquals(consumer.numberOfConsumedElements.get(), 1);
	}

	public class DelayObject implements Delayed {
		private String data;
		private long startTime;

		public DelayObject(String data, long delayInMilliseconds) {
			this.data = data;
			this.startTime = System.currentTimeMillis() + delayInMilliseconds;
		}

		@Override
		public int compareTo(Delayed o) {
			// TODO Auto-generated method stub
			return Ints.saturatedCast(this.startTime - ((DelayObject) o).startTime);
		}

		@Override
		public long getDelay(TimeUnit unit) {
			long diff = startTime - System.currentTimeMillis();
			return unit.convert(diff, TimeUnit.MILLISECONDS);
		}
	}

	public class DelayQueueProducer implements Runnable {

		public DelayQueueProducer(BlockingQueue<DelayObject> queue, Integer numberOfElementsToProduce,
				Integer delayOfEachProducedMessageMilliseconds) {
			super();
			this.queue = queue;
			this.numberOfElementsToProduce = numberOfElementsToProduce;
			this.delayOfEachProducedMessageMilliseconds = delayOfEachProducedMessageMilliseconds;
		}

		private BlockingQueue<DelayObject> queue;
		private Integer numberOfElementsToProduce;
		private Integer delayOfEachProducedMessageMilliseconds;

		// standard constructor

		@Override
		public void run() {
			for (int i = 0; i < numberOfElementsToProduce; i++) {
				DelayObject object = new DelayObject(UUID.randomUUID().toString(),
						delayOfEachProducedMessageMilliseconds);
				System.out.println("Put object: " + object);
				try {
					queue.put(object);
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}

	public class DelayQueueConsumer implements Runnable {
		public DelayQueueConsumer(BlockingQueue<DelayObject> queue, Integer numberOfElementsToTake) {
			super();
			this.queue = queue;
			this.numberOfElementsToTake = numberOfElementsToTake;
		}

		private BlockingQueue<DelayObject> queue;
		private Integer numberOfElementsToTake;
		public AtomicInteger numberOfConsumedElements = new AtomicInteger();

		// standard constructors

		@Override
		public void run() {
			for (int i = 0; i < numberOfElementsToTake; i++) {
				try {
					logger.info("====take "+System.currentTimeMillis());
					DelayObject object = queue.take();
					logger.info("====taked "+System.currentTimeMillis());
					numberOfConsumedElements.incrementAndGet();
					System.out.println("Consumer take: " + object);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}