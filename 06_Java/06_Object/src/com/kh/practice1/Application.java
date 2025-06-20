package com.kh.practice1;

import com.kh.practice1.model.UserInfo;

public class Application {

	public static void main(String[] args) {
		UserInfo ui = new UserInfo();
		
		ui.changeName("xxx");
		System.out.println(ui.printName());
	}

}
