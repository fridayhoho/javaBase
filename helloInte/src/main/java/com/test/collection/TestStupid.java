package com.test.collection;

/**
 * ClassName: TestStupid
 * Function:  TODO
 * Date:      2019-06-02 19:53
 * author     daguang
 * version    V1.0
 */
public class TestStupid {


	volatile  int result;

	public int getResult() {
		return result;
	}

	public synchronized void setResult(int result) {
		System.out.println("set:"+result);
		this.result = result;
	}

	public static void main(String[] args) {
		TestStupid testStupid = new TestStupid();
		for (int i = 0; i < 8; i++) {
			new Thread(() -> {
				int x = 0;
				while (testStupid.getResult() < 100) {
					System.out.println(x);
					testStupid.setResult(testStupid.getResult()+1);
				}
				System.out.println(x);
			}).start();
		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		testStupid.setResult(200);
	}
}
