package com.kh._abstract.step2;

public abstract class Pizza {

	protected int price;
	protected String brand;
	protected String ingredient;
	public Pizza(int price, String brand) {
		this.price = price;
		this.brand = brand;
		
	}
	
	
	// 여기서 부터는 자유롭게?
	public abstract void mainIngredients();
	
	public abstract void recipe();
	
	public abstract void info();
}
