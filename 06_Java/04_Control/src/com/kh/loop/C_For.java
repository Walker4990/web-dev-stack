package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class C_For {

	Scanner sc = new Scanner(System.in);
	
	
	/*
	 * for문
	 * 
	 * for(초기식; 조건식; 증감식) {
	 * 		실행코드 
	 * }
	 * 
	 * - 주어진 횟수만큼 코드를 반복 실행하는 구문
	 * - 초기식 : 반복문이 수행될 때 단 한 번만 실행, 반복문 안에서 사용할 변수를 선언하고 초기값 대입
	 * - 조건식 : 결과가 true이면 실행코드를 실행, false이면 실행하지 않고 반복문을 빠져나감.
	 * - 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용
	 * */
	
	
	public void method1() {
		// 1 ~ 5 출력
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}
	public void method2() {
	// 1~5 역순 출력
		for (int i = 5; i >= 1; i--) System.out.println(i);
	}
	
	public void method3() {
		//1 ~ 10 사이의 홀수만 출력
		for(int i = 1; i < 10; i+=2) System.out.println(i);
		System.out.println("------");
		for(int i = 1; i < 10; i++) {
			if(i %2!=0) System.out.println(i);
		}
		System.out.println("------");
		
		/*
		 * continue문
		 * - continue문은 반복문 안에서 사용
		 * - 반복문 안에서 continue를 만나면 "현재구문" 종료
		 * - 반복문을 빠져나가는 건 아님, 다음 반복 계속 수행
		 * */
		for(int i = 1; i < 10; i++) {
			if(i %2==0) continue; 
				System.out.println(i);
		}
	}
	
	public void method4() {
		int sum = 0;
		//1~ 10까지 합계
		for(int i=1; i < 11; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	public void method5() {
		// 1부터 사용자가 입력한 수까지의 합계
		int sum = 0;
		System.out.println("숫자 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	
	public void method6() {
		//1부터 랜덤값(2~10)까지의 합계
		int random =(int) (Math.random() * 9 + 2); // 0.0 <= random < 1.0
		Random random2 = new Random();
		int random3 = random2.nextInt(9) + 2; // 0 ~ 9 -> 2 ~ 11 2이상 11미만 
		int random4 = random2.nextInt(2, 11); // 2 ~ 11 2이상 11미만
		
		int sum = 0;
		for(int i = 0; i <= random; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
	
	public void method7() {
	/*
	 * 사용자한테 입력받은 문자열을 세로로 출력
	 * 사용자 입력 > hello
	 * h
	 * e
	 * l
	 * l
	 * o
	 * 출력
	 * */
		System.out.println("입력해주세요 : ");
		String str = sc.nextLine();
		for(int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		/*
		 * 향상된 for문
		 * for(데이터타입 변수 : 배열) {
		 * 		변수 : 배열의 값을 하나씩 가지고 옴
		 * }
		 * 문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열
		 * - .toCharArray() : 모든 문자가 들어있는 char[] 형식의 데이터 반환
		 * - charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환
		 * */
		System.out.println("--------");
		char[] arr = str.toCharArray();
		for(char ch : arr) {
			System.out.println(ch);
		}
	}
	// 중첩 for문
	/*
	 * *****
	 * *****
	 * *****
	 * *****
	 * 가로 5개 세로 4줄
	 * */
	public void method8() {
	for(int hei = 1; hei <= 4; hei++) {
		for(int wid = 1; wid <= 5; wid++) {
			System.out.print("*");
		} // println("*") -> 줄바꿈해버려서 print("*") 사용
		System.out.println(); // =>*5개마다 줄 바꿈 위해
	}
	}
	
	/*
	 * 1****
	 * *2***
	 * **3**
	 * ***4*
	 * ****5
	 * */
	public void method9() {
		for (int j = 1; j <= 5; j++) {
		for (int i = 1; i <= 5; i++) {
			if(i==j) System.out.print(j);
			else System.out.print("*");
		}
		System.out.println();
		}
		}
		
	/*
	 * * 		i=0,j=0
	 * ** 		i=1,j=0,j=1
	 * ***		i=2, j=0, j=1, j=2
	 * **** 	i=3, j=0, j=1, j=2, j=3
	 * *****	i=4, j=0, j=1, j=2, j=3, j=4
	 * */
	
//	public void method10() {
//		for (int j = 1; j <= 5; j++) {
//			// j번째 줄
//			for (int i = 1; i <= j; i++) {
//			System.out.print("*");
//				// j만큼 * 출력
//			}
//			System.out.println();
//			}
//			}
//	
	
	/*     *	i=0, j=4
	 *    **	i=1, j=3, j=4
	 *   *** 	i=2, j=2, j=3, j=4
	 *  ****	i=3, j=1, j=2, j=3, j=4
	 * *****	i=4, j=0, j=1, j=2, j=3, j=4
	 * */
	
	public void method11() {
//		int n = 5;
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				if (j <= n-i) System.out.print(" ");
//				else System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//	}
		for(int i = 0; i < 5; i++) {
			for(int j = 4; j>=0; j--) {
				if(i < j) System.out.print(" ");
				else System.out.print("*");
			}
			System.out.println();
			}
		}
	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
		c.method11();
		
	}

}
