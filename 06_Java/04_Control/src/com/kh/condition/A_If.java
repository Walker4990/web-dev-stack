package com.kh.condition;

import java.util.Scanner;

public class A_If {


	Scanner sc = new Scanner(System.in);

	
	/*
	 * if 문
	 * 
	 * if (조건식){
	 * 		조건식이 true -> 실행
	 * } else {
	 * 	 조건식이 false -> 실행
	 * }
	 * 
	 * - 보통 조건식에는 비교연산자나 논리연산자를 주로 사용
	 * */
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다." 출력
		// 아니면 "불합격입니다." 출력
		System.out.println("점수를 입력하세요 > ");
		int score = sc.nextInt();

		// 한 줄인 경우만 중괄호({}) 생략 가능
		if(score >= 60) System.out.println("합격입니다.");
		else System.out.println("불합격입니다.");
		
		// 삼항연산자
		System.out.println(score >= 60 ? "합격입니다." : "불합격입니다.");
	}
	
	public void method2() {
		// 본인의 이름을 입력했을 때 본인이면 "본인이다", 아니면 "본인이 아니다" 출력
		System.out.println("이름을 입력해주세요 > ");
		String name = sc.nextLine();
		
		System.out.println("name : " + System.identityHashCode(name));
		System.out.println("성예찬 : " + System.identityHashCode("성예찬")); 
		
		if(name.equals("성예찬"))
			System.out.println("본인이다.");
		else System.out.println("본인이 아니다.");
		// 왜 조건이 name == "성예찬"은 안될까	
		// => String의 경우 주소의 값을 비교하기 때문에 다르게 나옴.
		// equals()를 사용하면 값의 내용만 비교한다.
		
		
	}
	/*
	 * if - else if - else 문
	 * 
	 * if( 조건식 1 ) {
	 *  	조건식 1 > true >실행
	 * } else if ( 조건식 2) {
	 * 		조건식 1 > false && 조건식 2 > true >실행
	 * } else {
	 * 		조건식 1, 2 모두 false > 실행
	 * }
	 * 
	 * - else if의 갯수는 제한 X
	 * */
	
	public void method3() {
	/*
	 * 사용자에게 점수 (0~100)를 입력받아서 점수별로 등급 출력
	 * - 90점 이상 A
	 * - 80점 이상 90점 미만 B
	 * - 70점 이상 80점 미만 C
	 * - 60점 이상 70점 미만 D
	 * - 60점 미만 F
	 * */
//		System.out.println("점수를 입력하세요 > ");
//		int score = sc.nextInt();
//		char grade = '\u0000';
		
//		if (score >= 90) grade = 'A';
//		else if (score >= 80) grade = 'B';
//		else if (score >= 70) grade = 'C';
//		else if (score >= 60) grade = 'D';
//		else grade = 'F';
//		
//		System.out.println(grade +"등급");
		
		// -> 1~100점을 제한을 걸어야하기 때문에 맨 위 조건에 유효성검사를 넣는 것
		System.out.print("점수를 입력하세요 > ");
		int score = sc.nextInt();

		if (score < 0 || score > 100) {
		System.out.println("잘못 입력하셨습니다.");
			return;// <-- 유효성 검사
		}
		 else if (score >= 90) {
		    System.out.println("A등급");
		} else if (score >= 80) {
		    System.out.println("B등급");
		} else if (score >= 70) {
		    System.out.println("C등급");
		} else if (score >= 60) {
		    System.out.println("D등급");
		} else {
		    System.out.println("F등급");
		}

		// return -> 리턴을 만나는 순간 해당 메서드가 종료됨.
	}
	
	/*
	 * 세 정수를 입력했을 때 짝수만 출력
	 * 
	 * num1 입력 : 3
	 * num2 입력 : 4
	 * num3 입력 : 8
	 * */
	public void method4() {
		System.out.println("정수1 입력 > ");
		int num1 = sc.nextInt();
		
		System.out.println("정수2 입력 > ");
		int num2 = sc.nextInt();
		
		System.out.println("정수3 입력 > ");
		int num3 = sc.nextInt();
		
		if(num1 % 2 == 0) System.out.println(num1);
		if(num2 % 2 == 0) System.out.println(num2);
		if(num3 % 2 == 0) System.out.println(num3);
	}
	
	
	public static void main(String[] args) {

		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
		
	}

}
