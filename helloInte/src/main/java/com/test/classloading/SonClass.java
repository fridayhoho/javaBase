package com.test.classloading;

/**
 * ClassName: SonClass
 * Function:  TODO
 * Date:      2019-06-17 09:51
 * author     daguang
 * version    V1.0
 */
public class SonClass extends FatherClass {
	public static String name;
	static {
		System.out.println("son class init");
	}
}
