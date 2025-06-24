package com.kh._abstract.step1;

// 추상 클래스!
public abstract class Sports {

	protected int numOfPlayers; // 참여 인원 수

	public Sports(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	// 추상 메서드! 즉, 미완성된 메서드! 구현부가 없음 -> 자식클래스에서 '강제' 구현 
	// 추상 메서드를 가지고 있으려면 무조건 추상클래스여야 한다.
	public abstract void rule();
	
	
}
