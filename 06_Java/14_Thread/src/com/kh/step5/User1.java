package com.kh.step5;

public class User1 extends Thread{

	private Calculator calculator;
	
	public void run() {
		setName("Calculator User 1");
		calculator.setMemory(100);
	}
	
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
}
