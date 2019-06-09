package com.test.annotations;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * ClassName: MyAnnoParserTest
 * Function:  TODO
 * Date:      2019-06-08 08:39
 * author     daguang
 * version    V1.0
 */
public class MyAnnoParserTest {
//	private class NormalOne {
//		@MyNotNull
//		private String address;
//
//		public void setAddress(String address) {
//			this.address = address;
//		}
//
//		public String getAddress() {
//			return address;
//		}
//	}

	@Test
	public void testAnno() {
		NormalOne normalOne = new NormalOne();
		NormalOne normalOne2 = new NormalOne();
		normalOne2.setAddress("DT");
		try {
			assertFalse("1field is null", MyAnnoParser.INSTANCE.parseAnnotation(normalOne));
			assertTrue("2field is null", MyAnnoParser.INSTANCE.parseAnnotation(normalOne2));
		} catch (AnnoException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}