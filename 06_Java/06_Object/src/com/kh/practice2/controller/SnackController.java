package com.kh.practice2.controller;

import com.kh.practice2.model.Snack;

public class SnackController {

	private Snack snack = new Snack() ;
	
//	
	public String saveData(Snack snackData) {
		snack.setKind(snackData.getKind());
		snack.setName(snackData.getName());
		snack.setFlavor(snackData.getFlavor());
		snack.setNumOf(snackData.getNumOf());
		snack.setPrice(snackData.getPrice());
		return "저장완료";
	}
	
	public Snack confirmData() {
//		return snack.toString();
		return snack;
//		
//		snack.getKind() +"("+ snack.getName() + "-" +
//		snack.getFlavor() + ")" + snack.getNumOf() + "개 " + snack.getPrice()+"원";
	}
	
	
		
}
