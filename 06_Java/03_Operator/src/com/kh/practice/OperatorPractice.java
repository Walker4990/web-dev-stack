package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
//		o.method1();
//		o.method2();
//		o.method3();
//		o.method4();
//		o.method5();
//		o.method6();
//		o.method7();
		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.println("인원 수를 입력하세요 : ");
		int people = sc.nextInt();
		System.out.println("연필 갯수를 입력하세요 : ");
		int pencil = sc.nextInt();
		
		int pen = pencil / people;
		int last = pencil % people;
		System.out.println("나눠가진 연필 개수 : " + pen);
		System.out.println("남은 연필 개수 : " + last);
		
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.println("숫자 입력 : ");
		int num1 = sc.nextInt();
		// number 구하는 방법 중 num1 - num1 % 100으로 하는 방법도 있음
		int number = num1 / 100 * 100;
		System.out.println(number);
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.println("첫번째 숫자 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 숫자 : ");
		int num2 = sc.nextInt();
		System.out.println("세번째 숫자 : ");
		int num3 = sc.nextInt();
		
		String result = (num1 == num2) && (num2 == num3)? "true" : "false";
		System.out.println(result);
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.println("숫자 입력 : ");
		int num1 = sc.nextInt();
		
		String result = num1 % 2 == 0 ? "짝수다" : "짝수가 아니다"; 
		System.out.println(result);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		//주민번호 000000-0000000
		System.out.println("주민등록번호를 입력하세요 : ");
		String resiNum = sc.nextLine();
		
		 String result = resiNum.charAt(7) == '1' || resiNum.charAt(7) == '3' ? 
				 "남자" : resiNum.charAt(7) == '2' || resiNum.charAt(7) == '4' ? 
				 "여자" : "사람아님.";
				
	System.out.println(result);			
		
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.println("나이 입력 : ");
		int age = sc.nextInt();
		
		String result = age <= 13 ? "어린이" : age <= 19 ? "청소년" : "성인";
		System.out.println(result);	
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.println("사과 개수 : ");
		int apple = sc.nextInt();
		System.out.println("바구니 크기 : ");
		int basket = sc.nextInt();
		
		//사과 % 바구니 =0 딱맞는거
		/*
		 * 바구니 크기가 8 사과가 17 바구니 3개
		 * */
		int basketCount = (apple % basket == 0) ? (apple / basket) : (apple / basket + 1);
//		System.out.println((apple / count) + (apple % count == 0 ? 0 : 1));
	    System.out.println("필요한 바구니의 수 : " + basketCount);
	}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		System.out.println("초 : ");
		int second = sc.nextInt();
		
		int sec = second % 60;
		int min = (second%3600) / 60;
		int hour = second / 3600;
//		second -= hour * 3600;
//		second -= minute * 60;
		System.out.println(hour+ "시간 " + min +"분 " + sec + "초");
		
		
	}
	
}