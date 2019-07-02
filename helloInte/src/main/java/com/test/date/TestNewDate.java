package com.test.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * ClassName: TestNewDate
 * Function:  TODO
 * Date:      2019-06-14 11:04
 * author     daguang
 * version    V1.0
 */
public class TestNewDate {
	public static void main(String[] args) {
		test2();
	}


	public static void test0(){
		LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//当天零点SLF4J

		LocalDateTime localDateTime = LocalDateTime.now();
		ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
		Instant instant = localDateTime.atZone(shanghaiZoneId).toInstant();
		java.util.Date date = Date.from(instant);
		System.out.println(date);
	}
	public static void test(){
		String timeStr = "2019-02-01 00:01:12";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(timeStr, formatter);
		dateTime = dateTime.minusHours(10000);
		System.out.println(dateTime);

	}

	public static void test2(){

		ZoneOffset zoneOffset = ZoneOffset.of("+8");
		String timeStr = "2019-06-27 00:10:00";
		System.out.println(timeStr);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime localDateTimeOrin = LocalDateTime.parse(timeStr, formatter);
		long timeStamp = localDateTimeOrin.toEpochSecond(zoneOffset);
		System.out.println(timeStamp);
		LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(timeStamp, 0, zoneOffset);

		System.out.println(localDateTime.format(formatter));
	}
}
