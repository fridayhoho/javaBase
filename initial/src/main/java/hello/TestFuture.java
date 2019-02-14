package hello;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFuture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TestFuture tf = new TestFuture();
		Future<String> testFuture1 = tf.testF(4);
		Future<String> testFuture2 = tf.testF(5);
		while (!(testFuture1.isDone() && testFuture2.isDone())) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("t1 isDone: "+testFuture1.isDone() + " t2 isDone: "+testFuture2.isDone());
		}

		try {
			String rs = testFuture1.get(10, TimeUnit.SECONDS);
			String rs2 = testFuture2.get();
			System.out.println("got result1: " + rs + " rs2:"+rs2);
//			testFuture1.cancel(true);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	public Future<String> testF(int increase) {
		return executor.submit(() -> {
			Thread.sleep(5000);
			return "increase: " + (increase * increase);
		});
	}
}
