package com.test.array;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * ClassName: TestArrayTest
 * Function:  TODO
 * Date:      2019-05-30 21:24
 * author     daguang
 * version    V1.0
 */
public class TestArrayTest {

	@Test
	public void testGen(){
		TestArray.generateArrWithMissedSome(10, 4);
		TestArray.generateArrWithMissedSome(10, 3);
		TestArray.generateArrWithMissedSome(10, 2);
		TestArray.generateArrWithMissedSome(10, 1);
	}

}