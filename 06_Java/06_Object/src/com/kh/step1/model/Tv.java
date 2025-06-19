package com.kh.step1.model;

public class Tv {

	/*
	 * 1. 추상화 
	 * - 공통적인 특성만 뽑아내어 단순화 - 그림에서 스케치 느낌
	 * - 개발하는데 중요한 것만 뽑고 불필요한 정보는 숨김.
	 * */
	
	// TV라는 객체의 설계도 클래스
	// 속성(Property)
	// - 멤버 변수(member variable), 필드(field),특성(attribute)
	public boolean power; // 전원상태(on/off)]
	public int channel; // 채널
	
	
	// 기능(function) -> 속성의 상태를 변화 시킴
	// - 메서드(Method), 함수(function)
	public void power() { // TV를 끄거나 키는 기능
		power = !power;
	}
	
	public void channelUp() {
		// 채널 번호 높이기
		channel++;
	}
	
	public void channelDown() {
		// 채널 번호를 내리는 기능
		channel--;
	}
	
	
	
}
