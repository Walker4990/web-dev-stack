package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

public class Application {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Snack s = new Snack();
		SnackController snack = new SnackController(); 
		
		
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류를 입력하세요 : ");
		String kind = sc.nextLine();
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		System.out.print("맛을 입력하세요 : ");
		String flavor = sc.nextLine();
		System.out.print("갯수를 입력하세요 : ");
		int numOf = sc.nextInt();
		System.out.print("가격을 입력하세요 : ");
		int price = sc.nextInt();
		
		System.out.println(snack.saveData(kind, name, flavor, numOf, price));
		System.out.println(snack.confirmData());
	}

}
