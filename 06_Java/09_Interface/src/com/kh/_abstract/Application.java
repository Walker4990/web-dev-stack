package com.kh._abstract;

import com.kh._abstract.step1.*;
import com.kh._abstract.step2.*;

public class Application {
	/*
	 * 추상클래스(Abstract Class)
	 * - 미완성 클래스로 추상 메서드를 포함한 클래스
	 * - 미완성 클래스이기 때문에 new 연산자를 통해서 객체 생성 x
	 * - 일반적인 필드, 메서드 포함(변수 + 메서드 + 추상 메서드)
	 * - 객체 생성 할 수 없지만 참조형 변수 타입으로 사용 가능
	 * - 상속 관계로 다형성 적용 가능
	 * 
	 * 추상 메서드(Abstract Method)
	 * - 미완성 메서드로 중괄호 ({})가 구현되지 않는 메서드
	 * - 추상 클래스를 상속받는 자식 클래스에서 "반드시" 오버라이딩(재정의)
	 * - 오버라이딩(재정의) 해주지 않으면 컴파일 에러
	 * - 자식 클래스에 강제성 부여
	 * */
	
	public static void main(String[] args) {
		// 추상 클래스 -> 객체 생성 자체가 안됨.
		//Sports s = new Sports(5);
		// 다형성으로 인해 부모타입으로 가능!
		Sports b = new BasketBall(9);
		Sports f = new FootBall(11);
		
		b.rule();
		f.rule();
		
		/*
		 * 브랜드, 가격 상관없이 세가지 피자는 다 사용
		 * 
		 * - (mainIngredients)피자
		 * 해당 브랜드의 (mainIngredients)피자 가격은 ~ 원
		 * 피자 반죽과 함께 도우를 빚는다.
		 * 토핑은 (mainIngredients) 포함한다.
		 * 피자를 180도에서 10분간 굽는다.
		 * 피자를 8등분한다.
		 * 피자를 포장한다.
		 * 
		 * - (mainIngredients) 피자
		 * 해당 브랜드의 (mainIngredients)피자 가격은 ~ 원
		 * 피자 반죽과 함께 도우를 빚는다.
		 * 토핑은 파인애플 포함한다.
		 * 피자를 180도에서 10분간 굽는다.
		 * 피자를 8등분한다.
		 * 피자를 포장한다.
		 * 
		 * - 포테이토피자
		 * 해당 브랜드의 (mainIngredients)피자 가격은 ~ 원
		 * 피자 반죽과 함께 도우를 빚는다.
		 * 토핑은 (mainIngredients) 포함한다.
		 * 피자를 180도에서 10분간 굽는다.
		 * 피자를 8등분한다.
		 * 피자를 포장한다.
		 * 
		 * */
		Pizza potato = new PotatoPizza(20000, "피자헛");
		Pizza pineapple = new PineapplePizza(18000, "미스터피자");
		Pizza bulgogi = new BulgogiPizza(23000, "도미노피자");
		System.out.println("---------------------");
		Pizza [] pizza = {potato, pineapple, bulgogi};
		for(Pizza p : pizza) {
			p.info();
			p.recipe();
			System.out.println("---------------------");
		}
//		System.out.println("---------------------");
//		potato.recipe();
//		System.out.println("---------------------");
//		pineapple.recipe();
//		System.out.println("---------------------");
//		bulgogi.recipe();
	}

}
