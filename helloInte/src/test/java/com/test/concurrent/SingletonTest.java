package com.test.concurrent;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: SingletonTest
 * Function:  TODO
 * Date:      2019-05-28 17:27
 * author     daguang
 * version    V1.0
 */
public class SingletonTest {

	@Test
	public void test3() {
		long start = System.currentTimeMillis();
		int c2 = 0;
		for (int i = 0; i < 1350_0000; i++) {
			ASingleton aSingleton = ASingleton.getInstance();
			c2 += aSingleton.getCt();
		}
		System.out.println("aSingleton:" + (System.currentTimeMillis() - start));
	}

	@Test
	public void testSingleton() {

		long start = System.currentTimeMillis();
		int c3 = 0;
		for (int i = 0; i < 1350_0000; i++) {
			DoubleCheckNormal aSingleton = DoubleCheckNormal.getInstance();
			c3 += aSingleton.getCt();
		}
		System.out.println("DoubleCheckNormal:" + (System.currentTimeMillis() - start));
	}

	@Test
	public void test2() {
		long start = System.currentTimeMillis();
		int c1 = 0;
		for (int i = 0; i < 1350_0000; i++) {
			DoubleCheckSingleton doubleCheckSingleton = DoubleCheckSingleton.getInstance();
			c1 += doubleCheckSingleton.getCt();
		}
		System.out.println("doubleCheck:" + (System.currentTimeMillis() - start));
	}


}