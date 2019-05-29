package com.test.concurrent;

public class ASingleton {

	private static volatile ASingleton instance;
	private static Object mutex = new Object();
	private int ct;
	private ASingleton() {
	}

	public static ASingleton getInstance() {
		ASingleton result = instance;
		if (result == null) {
			synchronized (mutex) {
				result = instance;
				if (result == null)
					instance = result = new ASingleton();
			}
		}
		return result;
	}
	public int getCt(){
		return ct;
	}
}