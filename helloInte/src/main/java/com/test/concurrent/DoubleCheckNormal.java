package com.test.concurrent;

/**
 * ClassName: DoubleCheckNormal
 * Function:  TODO
 * Date:      2019-05-28 17:43
 * author     daguang
 * version    V1.0
 */
public class DoubleCheckNormal {
	private static DoubleCheckNormal instance;
	private int ct;

	private DoubleCheckNormal() {
	}

	public static DoubleCheckNormal getInstance() {

		if (instance == null) {
			synchronized (DoubleCheckNormal.class) {
				if (instance == null) {
					return instance = new DoubleCheckNormal();
				}
			}
		}
		return instance;
	}

	public int getCt() {
		return ct;
	}
}
