package com.test.pattern;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.Set;

/**
 * ClassName: TestPattern
 * Function:  TODO
 * Date:      2019-05-29 17:30
 * author     daguang
 * version    V1.0
 */
public class TestPattern {
	public static void main(String[] args) {
		SingletonEnum.INSTANCE.setValue(999);
//		what are u doing 10 thousands hours ago?
		String timeStr = "2019-02-01 00:01:12";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dateTime = LocalDateTime.parse(timeStr, formatter);
		dateTime = dateTime.minusHours(10000);
		System.out.println(dateTime);
//     now?
		System.out.println("now:"+LocalDateTime.now().format(formatter));
//		distance
		LocalDate now = LocalDate.now();

		LocalDate t2046 = LocalDate.parse("2046-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("year:"+t2046.getYear()+" month:"+t2046.getMonth());
		System.out.println("2046:"+t2046 + " now:"+now);
		long days = ChronoUnit.MONTHS.between(now, t2046);
		System.out.println("======");
//		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
//		Iterator iterator = allZoneIds.iterator();
//		while (iterator.hasNext()){
////			System.out.println(iterator.next());
//		}
		LocalDate marriedDate = LocalDate.parse("2008-05-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		long distanDays = ChronoUnit.DAYS.between(marriedDate, LocalDate.now());
		System.out.println("嫁给我:"+distanDays+" 天了");

		LocalDate toSz = LocalDate.parse("2015-05-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("来深圳:"+ChronoUnit.DAYS.between(toSz, LocalDate.now())+" 天了");

		LocalDate herBirth = LocalDate.parse("1982-10-03", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate meBirth = LocalDate.parse("1980-05-04", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("我出生后:"+ChronoUnit.DAYS.between(meBirth, herBirth)+" 天，你出生了");
	}
}
