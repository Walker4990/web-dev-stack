package com.kh.overriding.model;

import java.util.Objects;

import com.kh.inheritane.model.parent.Product;

/*
 * 클래스 간의 관계 : 상속 vs 포함
 * - 상속 관계 : ~은 ~이다 (is - a 관계)
 * - 포함 관계 : ~은 ~을 가지고 있다(has - a 관계)
 * 		ex) 고객이 제품을 가질 수 있냐 없냐
 * */

public class Customer {

	protected String name; // 고객이름
	protected String grade; // 고객 등급
	protected int bonusPoint; // 보너스 포인트
	protected double bonusRatio; // 보너스 적립 비율
	protected int price;
	
	// 포함관계 명시 -> MODEL (DB랑 1:1), JOIN (1:M)
	protected Product product;
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer() {}
	
	public Customer(String name) {
		this.name = name;
		this.grade = "SILVER";
		this.bonusRatio = 0.01;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
//		return "Customer [name=" + name + ", grade=" + grade + ","
//				+ " bonusPoint=" + bonusPoint + ", bonusRatio="
//				+ bonusRatio + "]";
		return name + "님의 등급은 " + grade + "이며, 지불해야하는 금액은 " +
				price +"원이며 적립된 포인트는 " + bonusPoint + "입니다.";
	}
	

	@Override
	public boolean equals(Object obj) {
		Customer c = (Customer) obj;
		return c.name == this.name;
	}

	public void calc(int price) {
		this.bonusPoint = (int) (price * bonusRatio);
		this.price = price;
	}
}


