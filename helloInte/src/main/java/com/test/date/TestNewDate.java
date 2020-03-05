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
		new TestNewDate().testSecond();
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

	private final ZoneOffset zoneOffset = ZoneOffset.of("+8");

	private final ZoneId zoneId = ZoneId.of("Asia/Shanghai");
	public void testSecond(){
		LocalDateTime dateTime = LocalDateTime.now(zoneId);

		long epochSecond = dateTime.toEpochSecond(zoneOffset);
		System.out.println(epochSecond);
		LocalDateTime newLocal = LocalDateTime.ofEpochSecond(epochSecond, 0, zoneOffset);
		System.out.println(newLocal.toString());
	}

	public void getBySeconds(){
		long time = 1562860039534L;
		LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(time, 0, zoneOffset);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(localDateTime.format(formatter));
	}

	public void testTimeEpoch(){
		String timeBeginS = "2019-07-30 00:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		java.time.ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime.getZone());//当前zone
		System.out.println("zoneDateTime epoch: "+zonedDateTime.toEpochSecond());

		LocalDateTime dateTimeS = LocalDateTime.parse(timeBeginS, formatter);
		long timeEpoch0 = dateTimeS.toEpochSecond(ZoneOffset.of("+0"));
		long timeEpoch8 = dateTimeS.toEpochSecond(ZoneOffset.of("+8"));
		System.out.println("timeEpoch0: "+timeEpoch0);
		System.out.println("timeEpoch8: "+timeEpoch8);
		/**
		 * String timeBeginStr = "2019-07-30 00:00:00";
		 * 对应的时间戳
		 * 一个Epoch millisecond
		 * 在不同zone下对应时间不同
		 */
		long time = 1564444800L;
		System.out.println("time:"+time);
		LocalDateTime dateTimeB = LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.of("+0"));
		System.out.println("utc: "+dateTimeB.format(formatter));
		LocalDateTime dateTimeC = LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.of("+8"));
		System.out.println("+8: "+dateTimeC.format(formatter));
//		https://vladmihalcea.com/a-beginners-guide-to-java-time-zone-handling/
	}
}
