package com.kh._interface.step2;

public class Tv implements RemoteControl, Searchable {

	@Override
	public void turnOn() {
		System.out.println("전원 켜짐");
	}

	@Override
	public void turnOff() {
		System.out.println("전원 꺼짐");
	}

	@Override
	public void search(String url) {
		System.out.println(url + " 검색");
	}

	@Override
	public void setVolume(int volume) {
		
		
	}

	
}
