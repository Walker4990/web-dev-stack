package com.kh.overriding;



import java.util.Scanner;

import com.kh.inheritane.model.parent.Product;
import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VipCustomer;

public class Application {

	/*
	 * SOLID의 O
	 * Open / Close Principle (개방-폐쇄의 원칙)
	 * -기존 코드를 변경하기 않고 확장 가능하게
	 * */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int price = 100000;
	
		
		
		// 금액 : 100000
		// ~~님의 등급은 ~~이며, 지불해야 하는 금액은 ~ 원이며, 적립된 포인트는 ~~점입니다.
		System.out.println("이름 입력 > ");
		String name = sc.nextLine();
		System.out.println("등급 : (일반/VIP) > ");
		String grade = sc.nextLine();
		System.out.println("금액을 입력하세요 > ");
		int price = sc.nextInt();
		
		
		Customer customer5 = null;
		
		if(grade.equals("VIP")) {
			customer5 = new VipCustomer(name);
		}else {
			customer5 = new Customer(name); 
		}customer5.calc(price);
		System.out.println(customer5);
		
		Product product = new Product();
		product.setBrand("LG");
		customer5.setProduct(product);
		System.out.println(customer5.getProduct().getBrand());
		
		
		// 내가한것 - 각 클래스의 toString 변경
		Customer customer1 = new Customer("서지은");
		customer1.calc(price);
		System.out.println(customer1);
		
		VipCustomer customer2 = new VipCustomer("김은진");
		customer2.calc(price);
		System.out.println(customer2);
		
		// 동명이인은 없다고 가정
		Customer customer3 = new Customer("서지은");
		VipCustomer customer4 = new VipCustomer("김은진");
		
		System.out.println(customer1.getName().equals(customer3.getName()));
		if (customer1.equals(customer3)) System.out.println("등록이 불가능합니다.");
		
		System.out.println(customer2.getName().equals(customer4.getName()));
		if (customer2.getName().equals(customer4.getName())) System.out.println("등록이 불가능합니다.");
		
		System.out.println("-------------------------------------------------------------------------");
		
		//getter, setter 를 활용해 여기서 변경
//		System.out.println(customer1.getName() +"님의 등급은 " + customer1.getGrade() +"이며, 지불해야하는 금액은 "
//		                 + customer1.getPrice() + "이며, 적립된 포인트는 " +
//		                   (customer1.getPrice() * customer1.getBonusRatio())+ "입니다.");
//		
//		System.out.println(customer2.getName() +"님의 등급은 " + customer2.getGrade() +"이며, 지불해야하는 금액은 "
//                + (customer2.getPrice() * customer2.getSaleRatio()) + "이며, 적립된 포인트는 " +
//                  (customer2.getPrice() * customer2.getBonusRatio())+ "입니다.");
//		System.out.println("-------------------------------------------------------------------------");
//		// 
//		
//		System.out.println("-------------------------------------------------------------------------");
//		
		
	
	}

	}
