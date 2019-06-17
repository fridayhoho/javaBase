package com.test.classloading;

/**
 * ClassName: ClassLoadTest
 * Function:  TODO
 * Date:      2019-06-17 09:50
 * author     daguang
 * version    V1.0
 */
public class ClassLoadTest {
	/**
	 * -XX:+TraceClassLoading
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println("age: "+SonClass.age);
//		SonClass[] sons = new SonClass[2];
//		System.out.println(FatherClass.age);
		System.out.println(FatherClass.addr);//常量池
	}


}
