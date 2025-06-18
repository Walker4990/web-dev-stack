package com.kh.loop;

import java.util.Scanner;

public class D_While {

	Scanner sc = new Scanner(System.in);
	
	/*
	 * while문
	 * 
	 * while(조건식) {
	 * 		조건이 true일 경우 계속 실행
	 * */
	
	// 1~5까지 출력
	public void method1() {
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	
	/*
	 * 무한루프 & break문
	 * - switch , 반복문의 실행을 중지하고 빠져나갈 때 사용
	 * - 반복문이 중첩되는 경우 break문이 포함되어 있는 반복문에서만 빠져나간다.
	 * */
	public void method2() {
		while(true) {
			//조건 true => 무한루프 처리하겠다
			System.out.println("숫자 입력 : ");
			int num = sc.nextInt();
			System.out.println(num);
			// num이 0인 경우 중지
			if(num == 0) break;
		}
	}
	
	/*
	 * do {
	 * 		실행 코드
	 * } while(조건식);
	 * - 조건과 상관없이 무조건 한 번은 실행
	 * */
	public void method3() {
		int number=1;
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		}while(number == 0);
	}
	
	/*
	 * 숫자 맞히기 게임
	 * 1과 100사이의 값 중에을 정답을 우리가 정하고
	 * 컴퓨터 (random)가 맞히도록 몇 번 만에 끝내는지 출력!
	 * 해당 숫자보다 정답이 높으면 up! 낮으면 down!
	 * */
	public void method4() {
		System.out.println("숫자를 입력하세요(1~100) : ");
		int num = sc.nextInt();
		int count = 0;
		int min = 1;
		int max = 100;
		
		
		while (true) {
			int number =(int)(Math.random() * (max-min+1) + min);
			++count; // 횟수 출력 위한 것
			
			if (num > number) {
				System.out.println(number + " up");
				min = number + 1;
			}
			else if (num < number) {
				System.out.println(number + " down");
				max = number - 1 ;
			}
			else {
				System.out.println(number + ", 정답!" + count +"번 만에 맞췄습니다.");
				break;
			}
			// else 안에 break을 넣어야 정답이라는 말과 함께 반복문 중지 가능
			
		}
	}
	/*
	 * 숫자 맞히기 게임 2
	 * 
	 * 컴퓨터(random)가 1과 100사이의 값 중에 정답을 정하고
	 * 우리가 맞히도록 몇 번 만에 끝내는지 출력!
	 * 해당 숫자보다 정답이 높으면 up! 낮으면 down!
	 * */
	public void method5() {
		int random = (int)(Math.random() * 100 + 1);
		int count = 0;
		
		
	
		while(true) {
			System.out.println("숫자를 입력해주세요 : ");
			int num = sc.nextInt();
			count++;
			if (random > num) {
				System.out.println(num+"보다 up"); 
			}
			else if(random < num) {
				 System.out.println(num + "보다 down");
			}
			else {
				System.out.println("정답!" + count +"회 만에 정답"); 
				break;
			}
		}
		
		
			
		}
		/*
		 * ---------------------------------
		 * 1. 예금(depost) | 2. 출금(withdraw) | 3. 잔고(balance) | 4. 종료(exit)
		 * ---------------------------------
		 * 선택 > 1
		 * 예금액 > 10000
		 * ---------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * ---------------------------------
		 * 선택 > 2
		 * 출금액 > 5000
		 * ---------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * ---------------------------------
		 * 선택 > 3
		 * 잔고 확인 > 5000
		 * ---------------------------------
		 * 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 * ---------------------------------
		 * 선택 > 4
		 * 프로그램 종료
		 * */
	public void method6() {
		int deposit = 0;
		int withdraw = 0;
		boolean check = true;
		while(check) {
			System.out.println("---------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("---------------------------------");
			System.out.println("메뉴 번호를 입력하세요 : ");
			int menu = sc.nextInt();
		switch(menu) {
		case 1:
			System.out.println("예금액을 입력하세요 : ");
			deposit += sc.nextInt();
			System.out.println("예금액 : " + deposit);
			break;
		case 2:
			System.out.println("출금액을 입력하세요 : ");
			withdraw += sc.nextInt();
			if (withdraw > deposit) {
				System.out.println("출금 불가능");
				return;
			}
			System.out.println("출금액 : " + withdraw);
			break;
		case 3: 
			System.out.println("잔고 : " + (deposit - withdraw));
			break;
		case 4:
			System.out.println("프로그램 종료");
//			return;
			check = false;
		default : System.out.println("잘못 입력하셨습니다.");
		break;
		// check = false 권장
		}
		}
		
		
	}

		public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
		d.method6();
	}

}
