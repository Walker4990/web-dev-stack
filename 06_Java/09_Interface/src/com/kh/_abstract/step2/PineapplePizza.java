package com.kh._abstract.step2;

public class PineapplePizza extends Pizza {
	String ingredient = "파인애플";
	public PineapplePizza(int price, String brand) {
		super(price, brand);

	}

	
	@Override
	public void recipe() {
		info();
		System.out.println("피자 반죽과 함께 도우를 빚는다.");
		mainIngredients();
		System.out.println("피자를 180도에서 10분간 굽는다.");
		System.out.println("피자를 8등분한다.");
		System.out.println("피자를 포장한다.");
	}

	@Override
	public void info() {
		System.out.println(this.brand + "의 파인애플피자 가격은 " + this.price +"원");
	}
	
	@Override
	public void mainIngredients() {
		System.out.println("토핑은 파인애플 포함한다.");
	}

}
