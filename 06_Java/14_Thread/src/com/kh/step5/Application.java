package com.kh.step5;

public class Application {

	public static void main(String[] args) {

		// 스레드들은 공유자원을 서로 공유한다.
		Calculator cal = new Calculator();
		
		User1 user1 = new User1();
		User2 user2 = new User2();
		
		// 공유자원 확인을 위해 작성
		user1.setCalculator(cal);
		user2.setCalculator(cal);
		
		// run() 직접 호출시 쓰레드가 실행되는 것이 아니라 main에서 실행되는 것
//		user1.run();
//		user2.run();

		user1.start();
		user2.start();
	}

}
