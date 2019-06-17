package com.test.classloading;

public class FatherClass {
	public static int age = 99;
	public static final String addr = "Shenzhen";
	static {
		System.out.println("father class init");
	}
}