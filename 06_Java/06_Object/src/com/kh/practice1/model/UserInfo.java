package com.kh.practice1.model;

public class UserInfo {

	
	public int userNo;
	public String id;
	public String pw;
	public String email;
	public String name;
	public String phone;
	public String addr;
	
	public UserInfo() {}
	
	public String printName() {
		return name;
	}
	
	public void changeName(String name) {
		this.name= name;
		// 이 클래스 내의 name -> 밖의 name으로 변경하겠다.
	}
	

	
	
	
	
	
	
	
}
