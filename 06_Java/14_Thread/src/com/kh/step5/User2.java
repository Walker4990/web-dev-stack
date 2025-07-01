package com.kh.step5;

public class User2 extends Thread{

	private Calculator calculator;
	
	public void run() {
		setName("Calculator User 2");
		calculator.setMemory(50);
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}
