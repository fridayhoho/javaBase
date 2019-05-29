package com.test.concurrent;

/**
 * ClassName: DeadLock
 * Function:  TODO
 * Date:      2019-05-29 10:52
 * author     daguang
 * version    V1.0
 */
public class DeadLock {

	private class Cell {
		private long value_;

		synchronized long getValue() {
			return value_;
		}

		synchronized void setValue(long v) {
			value_ = v;
		}

		synchronized void swapValue(Cell other) {
			long t = getValue();
			long v = other.getValue();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			setValue(v);
			other.setValue(t);
		}
	}
	private void test(){
		Cell cell = new Cell();
		Cell cell2 = new Cell();
		new Thread(new Runnable() {
			@Override
			public void run() {
				cell.swapValue(cell2);
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				cell2.swapValue(cell);
			}
		}).start();
	}
	public static void main(String[] args) {
		new DeadLock().test();
	}
}
