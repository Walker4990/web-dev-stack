package com.kh.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class B_Time {

	/*
	 * java.time 패키지 - Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공 (JDK 1.8) - LocalDate,
	 * LocalTime, LocalDateTime, ZonedDateTime 클래스 포함 - 날짜와 시간에 대한 다양한 메서드 제공
	 */

	/*
	 * LocalDateTime - 날짜와 시간 정보 모두 저장
	 */
	public void method1() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("today : " + now); // 현재 날짜+시간

		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2025, 6, 30, 12, 8, 10);
		System.out.println(when);

		// ZoneDateTime : LocalDateTime + 시간대(지역별)
		System.out.println("ZonedDateTime : " + ZonedDateTime.now());

		// 년, 월, 일, 요일, 시, 분, 초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonthValue() + "월");
		// getMonth - 영어 출력, getMonthValue - 숫자 출력
		System.out.println(now.getDayOfMonth() + "일");
		System.out.println(now.getDayOfWeek());
		System.out.println(now.getHour() + "시");
		System.out.println(now.getMinute() + "분");
		System.out.println(now.getSecond() + "초");
		
		
		// 날짜 조작
		LocalDateTime plusDay = now.plusDays(1).plusMonths(2).plusYears(1);
		System.out.println(plusDay);
		
		LocalDateTime minusDay = now.minusYears(1).minusMonths(1).minusDays(1);
		System.out.println(minusDay);
		
		LocalDateTime withDay = now.withYear(2026).withMonth(8).withDayOfMonth(15);
		System.out.println("withDay : "+withDay);
		
		//boolean
		System.out.println("isAfter : " + now.isAfter(withDay)); // 오늘이 해당 날짜보다 이후인가?
		System.out.println("isBefore : " + now.isBefore(withDay)); // 오늘이 해당 날짜보다 이전인가?
		
		// LocalDate : 날짜 정보저장
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate : " + localDate);
		
		localDate = LocalDate.of(2025, 12, 16);
		System.out.println("LocalDate2 : " + localDate);
		
		// LocalTime : 시간 정보 저장
		
		LocalTime localTime = LocalTime.now();
		System.out.println("LocalTime : " + localTime);
		
		localTime = LocalTime.of(17, 49, 59);
		System.out.println("LocalDate2 : " + localTime);
	}

	/*
	 * Period와 Duration
	 * - 날짜와 시간 간격을 표현하기 위한 클래스
	 * - Period : 두 날짜 간의 차이
	 * - Duration : 시간의 차이
	 * */
	public void method2() {
		LocalDate date1 = LocalDate.of(2025, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);
		
		Period pe = Period.between(date1, date2);
		System.out.println("period : " + pe); // P11M30D / 날짜
		
		System.out.println("year : " + pe.getYears());
		System.out.println("month : " + pe.getMonths());
		System.out.println("day : " + pe.getDays());
		
		System.out.println("year : " + pe.get(ChronoUnit.YEARS));
		System.out.println("month : " + pe.get(ChronoUnit.MONTHS));
		System.out.println("day : " + pe.get(ChronoUnit.DAYS));
		
		LocalTime time1 = LocalTime.of(1, 2, 3);
		LocalTime time2 = LocalTime.of(11, 59, 59);
		Duration du = Duration.between(time1, time2);
		System.out.println(du); //  PT10H57M56S / 시간
		
		System.out.println("Hour : " + du.toHours());
		System.out.println("Minute : " + du.toMinutes());
		System.out.println("Second : " + du.toSeconds());
		
		// 문자열을 LocalDate 객체로 파싱!
		LocalDate date = LocalDate.parse("2025-12-16");
		System.out.println(date);
		
		// DateTimeFormatter
		// 날짜와 시간을 포맷팅(Formatting)된 문자열로 변환하는 메서드를 제공하는 클래스
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime today = LocalDateTime.now();
		String format = today.format(dtf);
		System.out.println(format);
		
	}
	
	/*
	 * D-Day 계산기
	 * ChronoUnit.DAYS.between(날짜, 날짜)
	 * 또는 날짜.until(날짜, ChronoUnit.DAYS)
	 * */
	public void method3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("년 : ");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.println("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		
		LocalDate today = LocalDate.now();
		LocalDate newDay = LocalDate.of(year, month, day);
		
		long dDay = ChronoUnit.DAYS.between(newDay, today);
	
		
		if(dDay == 0) {
			System.out.println("D-Day");
		} else if (dDay < 0) {
			System.out.println("D" + dDay);
		} else System.out.println("D"+ dDay);
		
		long dDay2 = newDay.until(today, ChronoUnit.DAYS);
		if(dDay2 == 0) {
			System.out.println("D-Day");
		} else if (dDay2 < 0) {
			System.out.println("D" + dDay);
		} else System.out.println("D"+ dDay2);
	
		
	}
	public static void main(String[] args) {
		B_Time b = new B_Time();
//		b.method1();
//		b.method2();
		b.method3();
	}

}
