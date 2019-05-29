package com.test.concurrent;

/**
 * ClassName: DoubleCheckSingleton
 * Function:  TODO
 * Date:      2019-05-28 17:24
 * author     daguang
 * version    V1.0
 */
public class DoubleCheckSingleton {
	private static DoubleCheckSingleton instance;
	private int ct;
	private DoubleCheckSingleton() {
	}

	public static DoubleCheckSingleton getInstance() {
		DoubleCheckSingleton result = instance;
		if (instance == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (instance == null) {
					return result = instance = new DoubleCheckSingleton();
				}
			}
		}
		return result;
	}
	public int getCt(){
		return ct;
	}
}
