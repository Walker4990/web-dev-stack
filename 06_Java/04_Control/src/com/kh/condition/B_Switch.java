package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);
	/*
	 *  switch문
	 *  
	 *  switch(조건식) {
	 *  	case 값1 :
	 *   	조건식의 결과가 값1과 같은 경우 실행
	 *   			break;
	 *   	case 값2 : 
	 *   	조건식의 결과가 값2와 같은 경우 실행
	 *   		break;
	 *   	default : 
	 *   	조건식의 결과가 일치하는 case문이 없을 때 실행
	 *  }
	 *  
	 *  - case 문의 갯수는 제한 X
	 *  - 조건식 결과는 정수, 문자, 문자열이어야 한다.
	 *  - 조건문을 빠져나가려면 break가 필요하다
	 *  - default문은 생략 가능함.
	 * */
	public void method1 () {
		/*
		 * 숫자를 입력받아 1일 경우 "빨간색입니다"
		 * 2일 경우 "파란색입니다"
		 * 3일 경우 " 초록색입니다"
		 * 잘못 입력시 "잘못입력했습니다.
		 * */
		System.out.println("숫자를 입력 > ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1 :
			System.out.println("빨간색입니다.");
			break;
		case 2 : 
			System.out.println("파란색입니다.");
			break;
		case 3 : 
			System.out.println("초록색입니다.");
			break;
			default :
				System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	/*
	 * 주민번호를 입력받아 "남자"인지 "여자"인지 출력 (그 외에는 "사람이 아닙니다.")
	 * 주민번호 입력 : 000000 - 0000000
	 * */
	public void method2() {
		System.out.println("주민등록번호를 입력하세요 > ");
		String resiNum = sc.nextLine();
//		System.out.println(resiNum.length());
//		System.out.println(resiNum.charAt(0));
		//resiNum.charAt(0) -> char 타입이기 때문에 케이스 뒤의 값에 ''를 붙여야 데이터 타입이 맞음.
		
		// String noStr = no.substring(7, 8); 이것도 주민번호 7번째자리 출력
		// .substring(첫 인덱스, 끝 인덱스) 
		// Integer.parseInt(resiNum.charAt(7)) 하면 숫자로도 사용할 수 있음.
		
		// 뭘 .charAt(), .substring(), Integer.parseInt() 
		// 셋 중 뭘 사용해도 상관없지만 데이터 타입만 맞추면 됨.
		switch(resiNum.charAt(7)) {
			case '1': 
			case '3': 
				System.out.println("남자");
			    break;
			case '2':
			case '4': 
				System.out.println("여자");
			    break;
			default : 
				System.out.println("사람이 아닙니다.");
		}
	}

 	public static void main(String[] args) {
 		B_Switch b = new B_Switch();
// 		b.method1();
 		b.method2();
	}

}
