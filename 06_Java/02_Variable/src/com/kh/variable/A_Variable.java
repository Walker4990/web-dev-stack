package com.kh.variable;

public class A_Variable {
	
	/*
	 * 변수 (variabal)
	 * - 값을 저장하는 "공간"
	 * */

	public static void main(String[] args) {

		// 실행할 메서드가 있는 클래스 생성 (new)
		A_Variable variable = new A_Variable();
		
		// 생성한 클래스로 메서드 실행(호출)
//		variable.printValue();
//		variable.variableTest();
		variable.constant();
		
	}

	public void printValue( ) {
		// 원의 둘레와 원의 넓이를 출력
		// 원의 둘리 : 반지름 x 2 x 3.141592...
		// 원의 넓이(반지름 X  반지름 X 3.141592
		
		// 변수 사용하지 않고 
		System.out.println(30 * 2 * 3.141592);
		System.out.println(30 * 30 * 3.141592);
		
		// 변수 사용해서
		int r = 30;
		double pi = 3.141592;
		
		System.out.println(r * 2 * pi);
		System.out.println(r * r * pi);
		
		
	}
	public void variableTest() {
		/*
		 * 변수의 선언
		 * 
		 * 자료형 변수명;
		 * - 자료형 : 어떤 값을 저장할지, 어떤 크기의 메모리를 할당 받을지에대한 정보
		 * - 변수명 : 변수의 이름으로 값을 읽고, 쓰고 지우는 작업을 할 때 사용
		 * 
		 * 변수의 초기화
		 * 변수명 = 값;
		 * - 변수에 처음으로 값을 저장하는 것
		 * - '='는 오른쪽 값을 왼쪽 변수에 대입(저장)하는 연산자
		 * */
	

		
		 // * 기본 자료형(Primitive type) : 실제 값을 저장
		 // 스택 메모리에 생성도니 공간에 실제 변수값이 저장 
		 // 1. 논리형 : 1byte = 8bit
			boolean isTrue; // 변수 선언
			isTrue = true; // 변수 초기화
			
			boolean isFalse = false; // 변수 선언과 동시에 초기화
			
	     // 2. 문자형
			char ch = 'a';
			// 작은따옴표는 딱 한글자만 올 수있음.
			// char ch = 'ab' -->에러발생
			
		 // 3. 정수형
			byte bNum = 1; // 1byte(=8bit) -> 2^8 = 256 (-128~127)
//			bNum = 128; -> 에러발생! 오버플로우(overflow)
			short sNum = 128; // 2byte(=16bit) -> 2^16 
			int iNum = 922337283; // 4byte (기본)
			long lNum = 922337283458L; // 8byte - 숫자 뒤에 L(l)을 입력해야 사용할 수 있음
			
			System.out.println(lNum);
			
		 // 4. 실수형
			float fNum = 1.2F; // 4byte - 숫자 뒤에 F(f)를 입력
			double dNum = 1.2; // 8byte - (기본)
			
			System.out.println(fNum);
			
		 // * 참조 자료형 (클래스) : 4byte, 기본형을 제외한 나머지, 주소값 저장
		 // 실제 데이터 값은 힙 메모리에 저장하고, 스택 메모리의 변수 공간에는 실제 변수값이 저장된 힙 메모리의 위치값 저장	
			String name = "이진용"; // 자바에서 대문자로 시작하면 클래스임.
			String name2 = new String("이진용");
			System.out.println(name);
			
		 // 변수의 네이밍 규칙
		 // 1. 대소문자 구분
			int number;
			int Number;
			int NUMBER;
//			String number; 자료형이 달라도 변수명이 같으면 에러!
			
		 // 2. 숫자로 시작하면 안 된다. 숫자가 섞이는건 상관없음
//			int 1age;
			int a2g3e4;
			
		 // 3. 특수문자는 '_', '$'만 사용가능
			int _age;
			int age$;
//			int age%; -> 에러
			
		 // 4. 예약어(Reserved word)를 사용하면 안 된다.
//			int public;
//			int void;
			
		 // 5. (권장사항) camelCase
		 // 첫 글자는 항상 소문자, 여러 단어가 오면 대문자
			int maxNumber; // 자바에서 사용
			int max_number; // 자바에서는 x, 파이썬에서 사용 (스네이크 기법)
			int maxnumber; // 가능은 하지만 권장 x
	}
		 public void constant() {
			
			 int age = 20;
			 age = 25;
			 System.out.println(age);
			 
			 final int MAX_AGE = 25;
			 // final 자료형 변수명; ->  상수 처리
			 // 변하지 않는 값으로 특정 변수의 값이 변경되는 걸 원하지 않을 때 사용
			 // 초기화 이후에는 값을 변경할 수 없다.
			 // 상수의 네이밍 규칙은 대문자로 표기, 여러단어가 오면 _로 구분
			 //			 MAX_AGE = 20;
			 System.out.println(MAX_AGE);
		 }
			
			
			
			
			
			
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
}

