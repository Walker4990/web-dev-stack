package com.kh._abstract.step2;

public class BulgogiPizza extends Pizza {
	String ingredient = "불고기";

	public BulgogiPizza(int price, String brand) {
		super(price, brand);

	}

	

	@Override
	public void recipe() {
		info(); // 추상메서드에서 다른 추상메서드 호출 가능
		System.out.println("피자 반죽과 함께 도우를 빚는다.");
		mainIngredients();
		System.out.println("피자를 180도에서 10분간 굽는다.");
		System.out.println("피자를 8등분한다.");
		System.out.println("피자를 포장한다.");

	}

	@Override
	public void info() {
		System.out.println(this.brand + "의 불고기피자 가격은 " + this.price + "원");
	}
	@Override
	public void mainIngredients() {
		System.out.println("토핑은 불고기 포함한다.");
	}
}
/*
 * - (mainIngredients) 피자 해당 브랜드의 (mainIngredients)피자 가격은 ~ 원 피자 반죽과 함께 도우를 빚는다.
 * 토핑은 파인애플 포함한다. 피자를 180도에서 10분간 굽는다. 피자를 8등분한다. 피자를 포장한다.
 */