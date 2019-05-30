package com.test.pattern;

/**
 * ClassName: SingletonEnum
 * Function:  TODO
 * Date:      2019-05-29 17:27
 * author     daguang
 * version    V1.0
 */
public enum  SingletonEnum {
	INSTANCE;

	int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
