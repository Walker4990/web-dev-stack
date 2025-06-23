package com.kh.practice2.view;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;


//View : HTML, CSS, JavaScript로 해결
// 첫 번재 프로젝트 : JSP
// 두 번째 프로젝트 : React
public class SnackView {

	Scanner sc = new Scanner(System.in);
//	String kind;
//	String name;
//	String flavor;
//	int numOf;
//	int price;
	Snack snackData = new Snack(); // 자바 스크립트에서도 객체로 값을 한꺼번에 담아서 보냄.
	
	public void input(){
		System.out.println("스낵류를 입력하세요.");
		System.out.print("종류를 입력하세요 : ");
//		kind = sc.nextLine();
		snackData.setKind(sc.nextLine());
		System.out.print("이름을 입력하세요 : ");
		snackData.setName(sc.nextLine());
		System.out.print("맛을 입력하세요 : ");
		snackData.setFlavor(sc.nextLine());
		System.out.print("갯수를 입력하세요 : ");
		snackData.setNumOf(sc.nextInt());
		System.out.print("가격을 입력하세요 : ");
		snackData.setPrice(sc.nextInt());
	}
	public void result() {
		SnackController snack = new SnackController(); 
//		System.out.println(snack.saveData(snackData.getKind(), snackData.getName(),
//						snackData.getFlavor(), snackData.getNumOf(), snackData.getPrice()));
		System.out.println(snack.saveData(snackData));
		System.out.println(snack.confirmData());
	}
}
